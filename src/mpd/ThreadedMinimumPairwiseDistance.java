package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {
	public int GLOBALRESULT = Integer.MAX_VALUE;

	public synchronized void updateGlobalResult(int localResult) {
		if (localResult < GLOBALRESULT) {
			GLOBALRESULT = localResult;
		}

	}
	
	@Override
	public int minimumPairwiseDistance(int[] values) {

		Thread lowerLeft = new Thread(new lowerLeft(values));
		Thread bottomRight = new Thread(new bottomRight(values));
		Thread topRight = new Thread(new topRight(values));
		Thread center = new Thread(new center(values));

		lowerLeft.start();
		bottomRight.start();
		topRight.start();
		center.start();

		try {
			lowerLeft.join();
			bottomRight.join();
			topRight.join();
			center.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		return GLOBALRESULT;

	}

	private class lowerLeft implements Runnable {
		int[] values;
		int localresult = Integer.MAX_VALUE;
		
		public lowerLeft(int[] values){
			this.values = values;
		}

		@Override
		public void run() {
			int n = values.length;
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < i; j++) {
					int diff = Math.abs(values[i] - values[j]);
					if (diff < localresult){
						localresult = diff;
					}
				}
			}
			
			updateGlobalResult(localresult);
		}

	}

	private class bottomRight implements Runnable {
		int[] values;
		int localresult = Integer.MAX_VALUE;
		
		public bottomRight(int[] values){
			this.values = values;
		}

		@Override
		public void run() {
			int n = values.length;
			for (int i = n / 2; i < n; i++) {
				for (int j = 0; j < i - (n/2); j++) {
					int diff = Math.abs(values[i] - values[j]);
					if (diff < localresult){
						localresult = diff;
					}
				}
			}
			
			updateGlobalResult(localresult);
		}

	}

	private class topRight implements Runnable {
		int[] values;
		int localresult = Integer.MAX_VALUE;
		
		public topRight(int[] values){
			this.values = values;
		}

		@Override
		public void run() {
			int n = values.length;
			for (int i = n / 2; i < n; i++) {
				for (int j = n / 2; j < i; j++) {
					int diff = Math.abs(values[i] - values[j]);
					if (diff < localresult){
						localresult = diff;
					}
				}
			}
			
			updateGlobalResult(localresult);
		}

	}

	private class center implements Runnable {
		int[] values;
		int localresult = Integer.MAX_VALUE;
		
		public center(int[] values){
			this.values = values;
		}

		@Override
		public void run() {
			int n = values.length;
			for (int i = n / 2; i < n ; ++i) {
				for (int j = i - (n/2); j < n / 2; ++j) {
					int diff = Math.abs(values[i] - values[j]);
					if (diff < localresult){
						localresult = diff;
					}
				}
			}
			
			updateGlobalResult(localresult);
		}

	}

}
