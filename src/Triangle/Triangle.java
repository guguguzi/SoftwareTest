package Triangle;

public class Triangle {
	int[] value= {50,20,5,5,1,1,1};
	int sumOf() {
		int sum=0;
		for(int i=0;i<value.length;i++) {
			sum += value[i];
		}
		return sum;
	}
	public boolean  caculate(int x) {
		int sum = sumOf();
		if(x<=sum && x>=0) {
			for(int i=0;i<value.length;i++) {
				if(x>=value[i]){
					x = x-value[i];
				}
			}
			if(x==0) {
				return true;
			}
		}
		return false;
	}

}
