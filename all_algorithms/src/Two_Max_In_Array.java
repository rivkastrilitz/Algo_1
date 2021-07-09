public class Two_Max_In_Array {

    //כניסות למחסנית זה log n
   public static int find2Max(Node arr[],int start,int end){
       if(start<end) {
           ;

           int index = 0;

           int mid = (start + end) / 2;
           int i = find2Max(arr, start, mid);
           int j = find2Max(arr, mid + 1, end);

           if (arr[i].getNum() > arr[j].getNum()) {
               arr[i].st.push(arr[j].getNum());
               index = i;

           }else {
               arr[j].st.push(arr[i].getNum());
               index = j;
           }
           return index;
       }
       return start;
   }

    public static void max(int array[]){
       Node arr[]=new Node[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i]=new Node(array[i]);
            int max1Index=find2Max(arr,0, arr.length-1);
            System.out.println("max1 is"+" "+arr[max1Index].getNum());
            int max2=arr[max1Index].st.pop();
            while(!arr[max1Index].st.isEmpty()){
                int n=arr[max1Index].st.pop();
                if(n>max2)max2=n;


            }
            System.out.println("max2 is"+" "+max2);
        }

    }

    public static void main(String[] args) {
       int arr[]={1,4,56,8,5,32,5,6,7,8};
        max(arr);
    }



}
