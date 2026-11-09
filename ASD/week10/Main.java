public class Main{
    public static void main(String [] args){
        System.out.println("hi");
        int [] data ={10, 15, 9, 2, 3, 1, 8};
        System.out.println("Linear Search:");
        int key = 1;
        System.out.println(linearSearch(key, data));

        System.out.println("Insertion Sort:");
        insertionSort(data);
        System.out.println("Binary Search:");
        key = 15;
        System.out.println(binarySearch(key, data));

        

    }

    public static int binarySearch(int k,int[]data){
        int a=0;
        int b=data.length-1;
        while(a<=b){
            int m = (a+b)/2;
            if(data[m]==k){
                return m;
            } else if(data[m]<k){
                a=m+1;
            } else{
                b=m-1;
            }
        }
        return -1;
    }

    public static int linearSearch(int k, int[]data){
        for(int i=0;i<data.length;i++){
            if(data[i]==k){
                return i;
            }
        }
        return -1;
    }

    public static void insertionSort(int [] data){
        for(int a=1; a<=data.length-1;a++){
            int temp=data[a];
            for(int b=a-1;b>=0;b--){
                if(data[b]>temp){
                    data[b+1]=data[b];
                }
                else{
                    data[b+1]=temp;
                    break;
                }
                if(b==0){
                    data[b]=temp;
                }
            }
            
        }
        for(int d:data){
            System.out.print(d+" ");
        }
    }

    public static void selectionSort(int [] data){
        for(int a=0; a<=data.length-2;a++){
            int smallest=data[a+1];
            int iSmallest=a+1;
            for(int b=a+1;b<=data.length-1;b++){
                if(data[b]<smallest){
                    smallest=data[b];
                    iSmallest=b;
                }
            }
            if(smallest<data[a]){
                int temp=data[a];
                data[a]=data[iSmallest];
                data[iSmallest]=temp;
            }
        }
        for(int d:data){
            System.out.print(d+" ");
        }
    }

    public static void bubleSort(int [] data){
        for(int a=data.length-1;a>0;a--){
            for(int b=0;b<a;b++){
                if(data[b+1]>data[b]){
                    int temp = data[b];
                    data[b]= data[b+1];
                    data[b+1] =temp;
                }
            }
        }
    for(int d:data){
        System.out.print(d+" ");
    }

    }
}