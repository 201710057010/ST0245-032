
public class codigoEnLinea{
    // array 2
    public int countEvens(int[] nums) {
	int cont = 0;
	for(int i = 0; i < nums.length;i++){
	    if(nums[i] % 2 == 0)
		cont++;
	}
	return cont;
       }

    public int bigDiff(int[] nums) {
	int max = nums[0];
	int min = nums[0];
	for(int i = 1; i < nums.length;i++){
	    min = Math.min(min,nums[i]);
	    max = Math.max(max,nums[i]);
	}
	return max-min;
    }

    public int centeredAverage(int[] nums) {
	int max = nums[0];
	int min = nums[0];
	int indMax = 0;
	int indMin = 0;
	for(int i = 1; i < nums.length;i++){
	    if (Math.min(min,nums[i]) < min){
		min = Math.min(min,nums[i]);
		indMin = i;
	    }
	    if(Math.max(max,nums[i]) > max){
		max = Math.max(max,nums[i]);
		indMax = i;
	    }
	}
	nums[indMin] = 0;
	nums[indMax] = 0;
	int cont = 0;
	int acom = 0;
	for(int i = 0; i < nums.length;i++){
	    if(nums[i] != 0){
		cont++;
		acom = acom + nums[i];
	    }
	}

	return acom/cont;
    }

    public int sum13(int[] nums) {
	int cont = 0;
	for(int i = 0; i < nums.length;i++){
	    if(nums[i] != 13){
		cont = cont +  nums[i];
	    }
	    else if(nums[i]==13 && i < nums.length - 1){
		nums[i] = 0;
		nums[i+1]=0;
	    }

	}
	return cont;
    }

    public boolean has22(int[] nums) {
	if(nums.length <= 1){
	    return false;
	}
	for(int i = 0;i < nums.length-1;i++){
	    if(nums[i]==2 && nums[i+1]==2){
		return true;
	    }
	}
	return false;
    }

    //array 3
    public int maxSpan(int[] nums) {
	if (nums.length > 0) {
	    int maxSpan = 1;
	    for (int i = 0; i < nums.length; i++){
		for (int j = nums.length - 1; j > i; j--){
		    if (nums[j] == nums[i]) {
			int count = (j - i) + 1;
			if (count > maxSpan) maxSpan = count;
			break;
		    }
		}
	    }
	    return maxSpan;
	} else return 0;
      }
    
    public int[] fix34(int[] nums) {
	for (int i = 0; i < nums.length; i++)
	    if (nums[i] == 3) {
		int cont = nums[i + 1];
		nums[i + 1] = 4;
		for (int j = i + 2; j < nums.length; j++)
		    if (nums[j] == 4) nums[j] = cont;
	    }
	return nums;
    }

    public boolean canBalance(int[] nums) {
	for (int i = 0; i < nums.length; i++) {
	    int sum = 0;
	    for (int j = 0; j < i; j++){
		sum += nums[j];
	    }
	    for (int j = i; j < nums.length; j++){
		sum -= nums[j];
	    }
	    if (sum == 0) return true;
	}
	return false;
    }

    public int[] fix45(int[] nums) {
	for (int i=0;i<nums.length;i++)
	    if (nums[i] == 5 && i == 0 || nums[i] == 5 && nums[i - 1] != 4) {
		int a = i;
		for (int j = 0; j < nums.length; j++)
		    if (nums[j] == 4 && nums[j + 1] != 5) {
			int temp = nums[j + 1];
			nums[j + 1] = 5;
			nums[a] = temp;
			break;
		    }
	    }
	return nums;
    }

    public boolean linearIn(int[] outer, int[] inner) {
	int a = 0;
	int b = 0;
	while (a < inner.length && b  < outer.length) {
	    if (outer[b] == inner[a]) {
		b++;
		a++;
	    } else b++;
	}
	return (a == inner.length);
    }
}
