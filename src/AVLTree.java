
public class AVLTree<E extends Comparable<? super E>> extends BinarySearchTree<E>{
	
	public AVLTree(){
		super();
	}
	
	@Override
	public void incCount(E newData){
		overallRoot = this.incCount(overallRoot, newData);
	}
	

	public BSTNode incCount(BSTNode root, E newData){
		if (root == null){
			root = new BSTNode(newData);
			size++;
		}
		else {
			int compareResult = newData.compareTo(root.data);
			if (compareResult < 0){
				root.left = incCount(root.left, newData);
				
				if(getHeight(root.left) - getHeight(root.right) == 2){
					if(newData.compareTo(root.left.data) < 0){
						//System.out.println("rotateRight " + root.getData().getWord());
						root = rotateRight(root);
					}	
					else{
					//System.out.println("double left-right rotation " + root.getData().getWord());
					root = doubleLeftRightRotation(root);
					}
				}
			}
			else if (compareResult > 0){
				root.right = incCount(root.right, newData);
				
				if(getHeight(root.right) - getHeight(root.left) == 2){
					if(newData.compareTo(root.right.data) > 0){
						//System.out.println("rotateLeft " + root.getData(.getWord()));
						root = rotateLeft(root);
					}
					else {
						//System.out.println("double right-left rotation " + root.getData().getWord());
						root = doubleRightLeftRotation(root);
					}
				}
			}
			else {
				root.count++;
			}
		}
		//root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		return root;
	}
	
	private BSTNode rotateLeft(BSTNode root){
		BSTNode newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		return newRoot;
	}
	
	private BSTNode rotateRight(BSTNode root){
		BSTNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		return newRoot;
	}
	
	private BSTNode doubleLeftRightRotation(BSTNode root){
		root.left = rotateLeft(root.left);
		return rotateRight(root);
	}
	
	private BSTNode doubleRightLeftRotation(BSTNode root){
		root.right = rotateRight(root.right);
		return rotateLeft(root);
	}
	
	
	

}
