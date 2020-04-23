package lab9;

import javax.swing.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Your name here
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {

        if(key.compareTo(p.key)==0) {
            return p.value;
        } else if(key.compareTo(p.key)<0) {
            if(p.left==null) return null;
            return getHelper(key, p.left);
        }
        else {
            if(p.right==null) return null;
            return getHelper(key, p.right);
        }

    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {

        if(root==null) return null;
        return getHelper(key,root);

    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if(root==null){
            root=new Node(key,value);
            size++;
            return root;
        }

        if(key.compareTo(p.key)==0) {
            p.value=value;
            return root;
        } else if(key.compareTo(p.key)<0) {

            if(p.left==null) {
                p.left = new Node(key, value);
                size++;
            } else
                putHelper(key,value,p.left);

        } else {

            if(p.right==null) {
                p.right = new Node(key, value);
                size++;
            }else
                putHelper(key,value,p.right);

        }

        return root;
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {

        putHelper(key,value,root);

    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    private Node parent(Node p){
        if(p==root) return null;
        Node tempParent=root;
        Node temp=root;
        do{
            if(temp.key.compareTo(p.key)<0) {
                tempParent=temp;
                temp=temp.left;
            }else if(temp.key.compareTo(p.key)>0){
                tempParent=temp;
                temp=temp.right;
            }else{
                return tempParent;
            }
        }while(true);
    }

    private V realRemove(Node p){
        V reValue=p.value;
        if(p.left==null && p.right==null){
            p=null;
        }else if(p.left==null){
            Node parent=parent(p);
            if(parent.left==p) parent.left=p.right;
            if(parent.right==p) parent.right=p.right;

        }else if(p.right==null){
            Node parent=parent(p);
            if(parent.left==p) parent.left=p.left;
            if(parent.right==p) parent.right=p.left;
        }else{
            Node pLeftMostRight=p.left;
            while(pLeftMostRight.right!=null){
                pLeftMostRight=pLeftMostRight.right;
            }
            Node temp=new Node(pLeftMostRight.key,pLeftMostRight.value);
            temp.left=root.left;
            temp.right=root.right;
            root=temp;
            Node parent=parent(pLeftMostRight);
            if(parent.left==pLeftMostRight) parent.left=pLeftMostRight.left;
            if(parent.right==pLeftMostRight) parent.right=pLeftMostRight.left;
        }
        size--;

        return reValue;
    }

    /**
     *for recursive remove
     */
    private V removeHelper(K key, Node p){
        if(key.compareTo(p.key)==0)
            return realRemove(p);
        else if(key.compareTo(p.key)<0){
            if(p.left==null) return null;
            return removeHelper(key,p.left);
        }else{
            if(p.right==null) return null;
            return removeHelper(key,p.right);
        }

    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();

        //if(root==null) return null;

        //return removeHelper(key,root);
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
