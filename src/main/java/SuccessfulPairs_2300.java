import java.util.Arrays;

class SuccessfulPairs_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        //Time complexity = O(nlogm +mlogm)
        //nlogm = n=length of spells || m=length of potions
        //mlogm = m=length of potions || m=binary serch we are doing

        Arrays.sort(spells);
        int[] res = new int[spells.length];

        for(int i=0; i<spells.length; i++){
            int l = 0;
            int r = potions.length-1;
            int counter = potions.length;
            while(l<=r){
                int mid = l + (r-l)/2;
                if((long) spells[i] * potions[mid] >= success){
                    r = mid -1;
                    counter = mid;
                    
                }
                else{
                    l = mid+1;
                }
            }
            res[i] = potions.length - counter;
        }

        return res;
        
            

    }

    public static void main(String[] args) {
        SuccessfulPairs_2300 sol = new SuccessfulPairs_2300();
        int[] spells1 = {5, 1, 3};
        int[] potions1 = {1, 2, 3, 4, 5};
        int success1 = 7;
        System.out.println(Arrays.toString(sol.successfulPairs(spells1, potions1, success1))); // Expected: [4, 0, 3]

    }


    
}

