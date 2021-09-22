package practice;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hashing {
    // used to implement dictionaries (key-value pairs) or sets (only keys)
    // provides search, insert, delete in O(1) time on average
    // all values are unique, no duplicates are allowed
    // can't get all data in sorted order or closest value to given key, ideal for fetching specific value only

    // Direct Address Table : problems - can't handle large index or floating point numbers or strings
    public static boolean search(boolean[] table, int key){
        return table[key];
    }

    public static int insert(boolean[] table, int key){
        table[key]=true;
        return key;
    }

    public static int delete(boolean[] table, int key){
        if(table[key]){
            table[key]=false;
            return key;
        }
        else return -1;
    }

    // idea of hashing: take a large universe of keys (ph no, name, emp id) and convert keys into small values that can
    // be used as index for an array (known as hash table) with the help of Hash Functions

    // Hash functions: each time same index to be generated for a particular key
    // must only generate hash values from 0 to m-1 (m : size of hash table)
    // hash function should be fast, O(1) for integers and O(len) for strings of length 'len'
    // should ideally uniformly distribute large keys into hash table slots
    // Hash table size depends on num of keys to be inserted, should be proportional to number of entries ideally

    //Example hashing functions: for integers, Modulo division (key%m) m is usually prime and not close to powers |
    // for Strings, weighted sum str = "abcd" hash value for str = str[0]*x^0 + str[1]*x^1 + str[2]*x^2 + str[3]*x^4
    // Universal Hashing : make sure expected time is O(1), eases uniform distribution of keys

    // Collision Handling
    // If we know all keys in advance, then we can use perfect hashing (avoid all collisions, requires more preprocessing)
    // If we don't know all the keys, we can use one of the following:
    //                              - chaining
    //                              = open addressing : *Linear Probing | *Quadratic Probing | *Double Hashing

    // chaining: maintain an array of linked list, whenever collision happens, insert the item at the end of the LinkedList
    // m: num of slots in hash table | n: num of keys to be inserted | load factor(alpha) : n/m (how big hash table must be)
    // expected chain length for random set of keys : if uniformly distributed - alpha, else worst case - n
    // expected time to search: O(1+alpha) 1 to compute hash function, alpha for chain traversal
    // expected time to insert and delete: O(1+alpha)
    // Data Structure to implement chains in hash tables: linked list, dynamic arrays (cache friendly), self-balancing BST

    class ChainHash{
        int bucket;
        ArrayList<LinkedList<Integer>> table;
        ChainHash(int b){
            bucket = b;
            table = new ArrayList<LinkedList<Integer>>();
            for(int i=0;i<b;i++)
                table.add(new LinkedList<Integer>());
        }
        void insert(int key){
            int index = key%bucket;
            table.get(index).add(key);
        }
        void delete(int key){
            int index = key%bucket;
            table.get(index).remove((Integer) key);
        }
        boolean search(int key){
            int index = key%bucket;
            return (table.get(index).contains(key));
        }
    }

    // Open Addressing (cache friendly, single array used)
    // linear probing: linearly search for next empty slot when there is a collision and store key in it
    // search in a circular manner, if last index of array filled, start from the beginning
    //  search: compute hash function | go to index | compare | if key found return true, else linearly search |
    //  stop searching when 1.key found 2.empty slot found 3.entire table is traversed
    //  delete: don't make slot empty, mark it 'deleted' instead (allow new key to be inserted in deleted slot)
    //  (don't stop search when deleted slot is encountered)

    class OpenAddrHash{
        // -1 empty slot and -2 deleted key
        int[] arr;
        int cap, size;
        OpenAddrHash(int c){
            cap = c;
            size = 0;
            for(int i=0;i<cap;i++) arr[i]=-1;
        }
        int hash(int key){
            return key%cap;
        }
        boolean search(int key){
            int h=hash(key);
            int i=h;
            while(arr[i]!=-1){
                if(arr[i]==key)
                    return true;
                i=(i+1)%cap;
                if(i==h)
                    return false;
            }
            return false;
        }
        boolean insert(int key){
            if(size==cap) return false;
            int i = hash(key);
            while(arr[i]!=-1 && arr[i]!=-2  && arr[i]!=key)
                i=(i+1)%cap;
            if(arr[i]==key) return false;
            else{
                arr[i]=key;
                size++;
                return true;
            }
        }
        boolean delete(int key){
            int h = hash(key);
            int i = h;
            while(arr[i]!=-1){
                if(arr[i]==key){
                    arr[i]=-2; // delete same as search except for this line, as key must be removed after it is found
                    return true;
                }
                i=(i+1)%cap;
                if(i==h) return false;
            }
            return false;
        }

    }

    // clustering: problem with linear probing | solution: quadratic probing / double hashing
    // quadratic probing = (h(key)+i^2)%m | secondary clusters formed still problematic but better than primary clusters
    // quadratic probing works only if load factor (num keys/size of hash table) <0.5 and modulo of prime taken for hash function
    // double hashing = keys distributed more uniformly, clusters not formed
    // hash(key,i) = (h1(key)+i*h2(key))%m h2 can't return 0 as same location probed, h2 key and m must be co-prime
    // Performance analysis of search (alpha=n/m (n-total keys, m-size of hash table) (should be <=1)
    // assumption: each probe looks at a random location | (1-alpha): fraction of table empty | num of required probes: 1/(1-alpha)

    int[] linearProbing(int hash_size, int[] arr, int sizeOfArray)
    {
        int[] hash = new int[hash_size];
        for(int i=0;i<hash_size;i++){
            hash[i]=-1;
        }
        for(int i=0;i<sizeOfArray;i++)
        {
            int x=arr[i]%hash_size;
            if(hash[x]==-1 || hash[x] == arr[i] ){      // to handle duplicates
                hash[x]=arr[i];
            }
            else{
                int t=arr[i];
                while(hash[t%hash_size]!=-1 ){
                    t++;
                    if(t-arr[i]>hash_size || hash[t%hash_size] == arr[i])
                        break;
                }
                if(t-arr[i]>hash_size || hash[t%hash_size] == arr[i] ){
                    // break;      // as there can be duplicates .. so if we get here it doesn't mean there is no empty space
                    continue;
                } else {
                    hash[t%hash_size]=arr[i];
                }
            }
        }
        return hash;
    }


}
