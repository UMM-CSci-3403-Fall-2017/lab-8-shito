package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {
	public final int GLOBALRESULT = Integer.MAX_VALUE;
	private int[] values;

	public synchronized void updateGlobalResult(int localResult) {
		if (localResult < GLOBALRESULT) {
			localResult = GLOBALRESULT;
		}

	}

	/*public ThreadedMinimumPairwiseDistance() {

	}

	private ThreadedMinimumPairwiseDistance(int[] values) {
		this.values = values;
	}
*/
	@Override
	public int minimumPairwiseDistance(int[] values) {

		Thread lowerLeft = new Thread(new lowerLeft());
		Thread bottomRight = new Thread(new bottomRight());
		Thread topRight = new Thread(new topRight());
		Thread center = new Thread(new center());
		
		lowerLeft.start();
		bottomRight.start();
		topRight.start();
		center.start();
		
		try{
			lowerLeft.join();
			bottomRight.join();
			topRight.join();
			center.join();
		} catch(InterruptedException e){
			System.out.println(e);
		}

		//throw new UnsupportedOperationException();
		return -1;

	}

	private class lowerLeft implements Runnable {
		int[] values;

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
