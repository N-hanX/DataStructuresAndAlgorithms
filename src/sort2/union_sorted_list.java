package sort2;

public class union_sorted_list {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 4, 4, 7, 9, 15};
        int[] b = new int[]{2, 4, 4, 5, 6, 8, 10};

        int[] result = union_sorted_list(a, b);
        int n = 5;
    }

    public static int[] union_sorted_list(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        int result_ptr = 0;
        int a_ptr = 0;
        int b_ptr = 0;
        int prev = Integer.MIN_VALUE;

        while(a_ptr < a.length && b_ptr < b.length){
            if(a[a_ptr] < b[b_ptr] && prev != a[a_ptr]){
                result[result_ptr] = a[a_ptr];
                prev = a[a_ptr];
                a_ptr++;
                result_ptr++;
            }else if(a[a_ptr] > b[b_ptr] && prev != b[b_ptr]){
                result[result_ptr] = b[b_ptr];
                prev = b[b_ptr];
                b_ptr++;
                result_ptr++;
            }else if(a[a_ptr] == b[b_ptr] && prev != a[a_ptr]){
                result[result_ptr] = b[b_ptr];
                prev = a[a_ptr];
                result_ptr++;
                a_ptr++;
                b_ptr++;
            }else if(prev == a[a_ptr] && prev == b[b_ptr]){
                a_ptr++;
                b_ptr++;
            }else if(prev == a[a_ptr]){
                a_ptr++;
            }else if(prev == b[b_ptr]){
                b_ptr++;
            }
        }

        while(a_ptr < a.length){
            if(prev != a[a_ptr]){
                result[result_ptr] = a[a_ptr];
                a_ptr++;
                result_ptr++;
            }else{
                a_ptr++;
            }
        }

        while(b_ptr < b.length){
            if(prev != b[b_ptr]){
                result[result_ptr] = b[b_ptr];
                b_ptr++;
                result_ptr++;
            }else{
                b_ptr++;
            }
        }
        return result;
    }
}
