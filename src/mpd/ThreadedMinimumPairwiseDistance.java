package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {
	public final int GLOBALRESULT = Integer.MAX_VALUE;

	public synchronized void updateGlobalResult(int localResult) {
		if (localResult < GLOBALRESULT) {
			localResult = GLOBALRESULT;
		}

	}

	/*
	 * public ThreadedMinimumPairwiseDistance() {
	 * 
	 * }
	 * 
	 * private ThreadedMinimumPairwiseDistance(int[] values) { this.values =
	 * values; }
	 */
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

		// throw new UnsupportedOperationException();
		return -1;

	}

	private class lowerLeft implements Runnable {
		int[] values;
		
		public lowerLeft(int[] values){
			this.values = values;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < values.length / 2; ++i) {
				for (int j = 0; j < i; ++j) {
					// Gives us all the pairs (i, j) where 0 ≤ j < i <
					// values.length
					int diff = Math.abs(values[i] - values[j]);
					if (diff < result) {
						result = diff;
					}
				}
			}
		}

	}

	private class bottomRight implements Runnable {
		int[] values;
		
		public bottomRight(int[] values){
			this.values = values;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < values.length / 2; ++i) {
				for (int j = 0; j < i; ++j) {
					// Gives us all the pairs (i, j) where 0 ≤ j < i <
					// values.length
					int diff = Math.abs(values[i] - values[j]);
					if (diff < result) {
						result = diff;
					}
				}
			}
		}

	}

	private class topRight implements Runnable {
		int[] values;
		
		public topRight(int[] values){
			this.values = values;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < values.length / 2; ++i) {
				for (int j = 0; j < i; ++j) {
					// Gives us all the pairs (i, j) where 0 ≤ j < i <
					// values.length
					int diff = Math.abs(values[i] - values[j]);
					if (diff < result) {
						result = diff;
					}
				}
			}
		}

	}

	private class center implements Runnable {
		int[] values;
		
		public center(int[] values){
			this.values = values;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < values.length / 2; ++i) {
				for (int j = 0; j < i; ++j) {
					// Gives us all the pairs (i, j) where 0 ≤ j < i <
					// values.length
					int diff = Math.abs(values[i] - values[j]);
					if (diff < result) {
						result = diff;
					}
				}
			}
		}

	}

}
