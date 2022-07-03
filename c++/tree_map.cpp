#include "tree_map.h"
#include <stdio.h>
#include <stdlib.h>

//�������ÿ����㶼������ɫ���ԵĶ������������ɫ���ɫ���ɫ��[3]  �ڶ��������ǿ��һ��Ҫ�����⣬�����κ���Ч�ĺ�����������������µĶ���Ҫ��:
//����1.����Ǻ�ɫ���ɫ��[3]
//����2.������Ǻ�ɫ��[3]
//����3.����Ҷ�Ӷ��Ǻ�ɫ����Ҷ����NIL��㣩[3]
//����4.ÿ����ɫ���������ӽ�㶼�Ǻ�ɫ������ÿ��Ҷ�ӵ���������·���ϲ��������������ĺ�ɫ��㣩
//����5.����һ�ڽ�㵽��ÿ��Ҷ�ӵ�����·����������ͬ��Ŀ�ĺ�ɫ��㡣[3]

void TreeMap::inorderTraversal() {
	inorderTraversal(this->root);
}
void TreeMap::inorderTraversal(Node* node) {
	if (node == this->nil) {
		return;
	}
	inorderTraversal(node->left);
	printf("key = %d, value = %d, color = %c, parentKey = %d, parentColor = %c\n", node->key, node->value, node->color, node->parent->key, node->parent->color);
	inorderTraversal(node->right);
}
TreeMap::Node* TreeMap::rbGet(int key) {
	Node* res = this->root;
	while (res != this->nil) {
		if (res->key == key) {
			return res;
		}
		else if (res->key > key) {
			res = res->left;
		}
		else {
			res = res->right;
		}
	}
	return NULL;
}

TreeMap::Node* TreeMap::getMiniNode(Node* node) {
	while (node->left != this->nil) {
		node = node->left;
	}
	return node;
}
void TreeMap::rbTransplant(Node* cur, Node* pre) {
	if (pre->parent == this->nil) {
		this->root = cur;
	}
	else if (pre->parent->left == pre) {
		pre->parent->left = cur;
	}
	else {
		pre->parent->right = cur;
	}
	cur->parent = pre->parent;
}

bool TreeMap::rbDeleteFixup(Node* x) {
	while (x != this->root && x->color == BLACK) {
		if (x->parent->left == x) {
			Node* w = x->parent->right;
			if (w->color == RED) {//�Ѻ�ɫ��ڵ�Ϊx���ڵ�Ϊcase2������
				w->color = BLACK;
				x->parent->color = RED;
				leftRotate(x->parent);
				w = x->parent->right;
			}
			if (w->left->color == BLACK && w->right->color == BLACK) {//������֧·����1�ڸ�,xһֱ����ֱ����Ϊ��ɫ�ڵ�,�˳�ѭ�����ٽ�x�ڵ�ת��Ϊ��ɫ���ӵ�ǰ·���ĺڸ�
				w->color = RED;
				x = x->parent;
			}
			else if (w->right->color == BLACK) {//��w->right->colorת��Ϊ��ɫ,Ҳ����ת��Ϊcase4������ѭ��
				w->color = RED;//��ǰ��������Ϊ�˲��úڸ߱仯 ��ǰ��Ϊ��ɫ��תΪ��ɫ
				w->left->color = BLACK;
				rightRotate(w);
			}
			else {//�ұߺڸ߲���������ߺڸ�(�������w->right->color��Ϊ��ɫ)
				w->color = x->parent->color;
				w->right->color = BLACK;
				x->parent->color = BLACK;
				leftRotate(x->parent);
				x = this->root;
			}
		}
		else {
			Node* w = x->parent->left;
			if (w->color == RED) {
				w->color = BLACK;
				x->parent->color = RED;
				rightRotate(x->parent);
				w = x->parent->left;
			}
			if (w->left->color == BLACK && w->right->color == BLACK) {
				x = x->parent;
				w->color = RED;
			}
			else if (w->left->color == BLACK) {
				w->right->color = BLACK;
				w->color = RED;
				leftRotate(w);
			}
			else {
				w->color = x->parent->color;
				x->parent->color = BLACK;
				w->left->color = BLACK;
				rightRotate(x->parent);
				x = this->root;
			}
		}
	}
	x->color = BLACK;
	return true;
}

bool TreeMap::rbDelete(Node* node) {
	Node* y = node, * x;
	TreeMap::Color org_color = y->color;
	if (node->left == this->nil) {
		x = node->right;
		rbTransplant(x, y);
	}
	else if (node->right == this->nil) {
		x = node->left;
		rbTransplant(x, y);
	}
	else {
		y = getMiniNode(node->right);
		org_color = y->color;
		x = y->right;
		if (y->parent == node) {
			x->parent = y;
		}
		else {
			rbTransplant(x, y);
			y->right = node->right;
			node->right->parent = y;
		}
		y->color = node->color;
		y->left = node->left;
		node->left->parent = y;
		rbTransplant(y, node);
	}
	delete node;
	if (org_color == BLACK) {
		return rbDeleteFixup(x);
	}
	return true;
}

bool TreeMap::rbDelete(int key) {
	return rbDelete(rbGet(key));
}

void TreeMap::rightRotate(Node* pre) {
	Node* cur = pre->left;
	pre->left = cur->right;
	if (cur->right != this->nil) {
		cur->right->parent = pre;
	}
	if (pre->parent == this->nil) {
		this->root = cur;
	}
	else if (pre == pre->parent->left) {
		pre->parent->left = cur;
	}
	else {
		pre->parent->right = cur;
	}
	cur->parent = pre->parent;
	pre->parent = cur;
	cur->right = pre;
}

void TreeMap::leftRotate(Node* pre) {
	Node* cur = pre->right;
	pre->right = cur->left;
	if (cur->left != this->nil) {
		cur->left->parent = pre;
	}
	if (pre->parent == this->nil) {
		this->root = cur;
	}
	else if (pre->parent->left == pre) {
		pre->parent->left = cur;
	}
	else {
		pre->parent->right = cur;
	}
	cur->parent = pre->parent;
	pre->parent = cur;
	cur->left = pre;
}

bool TreeMap::rbPutFixup(Node* node) {
	while (node->parent->color == RED) {
		if (node->parent->parent->left == node->parent->parent) {
			if (node->parent->parent->right->color == RED) {//��Ӱ��ڸߣ�������ɫ�ڵ��λ��	
				node->parent->parent->right->color = BLACK;
				node->parent->parent->color = RED;
				node->parent->color = BLACK;
				node = node->parent->parent;
			}
			else if (node == node->parent->right) {//��Ӱ��ڸߣ��Ѻ�ɫ�ڵ㶥��ȥ
				node = node->parent;
				leftRotate(node);
			}
			else {//����޲�
				node->parent->color = BLACK;
				node->parent->parent->color = RED;
				rightRotate(node->parent->parent);
			}
		}
		else {
			if (node->parent->parent->left->color == RED) {
				node->parent->parent->left->color = BLACK;
				node->parent->parent->color = RED;
				node->parent->color = BLACK;
				node = node->parent->parent;
			}
			else if (node == node->parent->left) {
				node = node->parent;
				rightRotate(node);
			}
			else {
				node->parent->color = BLACK;
				node->parent->parent->color = RED;
				leftRotate(node->parent->parent);
			}
		}
	}
	this->root->color = BLACK;
	return true;
}

bool TreeMap::rbPut(Node* node) {
	Node* y = this->nil, * x = this->root;
	while (x != this->nil) {
		y = x;
		if (node->key > x->key) {
			x = x->right;
		}
		else {
			x = x->left;
		}
	}
	node->parent = y;
	if (y == this->nil) {
		this->root = node;
	}
	else if (y->key > node->key) {
		y->left = node;
	}
	else {
		y->right = node;
	}
	node->left = this->nil;
	node->right = this->nil;
	return rbPutFixup(node);
}

bool TreeMap::rbPut(int key, int value) {
	Node* node = new Node;
	if (node == NULL) {
		printf("�ڴ����ʧ�ܣ�������ֹ");
		exit(-1);
	}
	node->key = key;
	node->value = value;
	node->color = RED;
	return rbPut(node);
}
