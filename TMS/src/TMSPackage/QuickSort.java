package TMSPackage;

public class QuickSort {

    private static <T extends Comparable<T>> 
    int split(Account[] list, int lo, int hi, ComparableObject obj) {
        int left=lo+1;
        int right=hi;
        Account pivot = list[lo];
        
        while (true) {
            while (left <= right) {
                T temp = obj.getCombarableObject(list[left]);
                if (temp.compareTo(obj.getCombarableObject(pivot)) < 0) {
                    left++;
                } else {
                    break;
                }
            }

            while(right > left) {
                T temp = obj.getCombarableObject(list[right]);
                if (temp.compareTo(obj.getCombarableObject(pivot)) < 0) {
                    break;
                } else {
                    right--;
                }
            }

            if (left >= right) {
                break;
            }

            // swap left and right items
            Account temp = list[left];
            list[left] = list[right];
            list[right] = temp;
            //advance each one step
            left++; right--;
        }
        
        // swap pivot with left-1 position
        list[lo] = list[left-1];
        list[left-1] = pivot;
        // return the split point
        
        return left-1;
    }
    
    private static <T extends Comparable<T>>
    void sort(Account[] list, int lo, int hi, ComparableObject obj) {
        if ((hi-lo) <= 0) { // fewer than 2 items
            return;
        }
        int splitPoint = split(list,lo,hi, obj);
        sort(list,lo,splitPoint-1, obj);  // left subarray recursion
        sort(list,splitPoint+1,hi, obj);  // right subarray recursion
    }
    
    public static <T extends Comparable<T>>
    void sort(Account[] list, ComparableObject obj) {
        if (list.length <= 1) {
            return;
        }
        sort(list,0,list.length-1, obj);
    }
    
    
    
    
    
}