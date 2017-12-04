package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {
	public final int GLOBALRESULT = Integer.MAX_VALUE;

	@Override
	public int minimumPairwiseDistance(int[] values) {

		lowerLeft thread1 = new lowerLeft();
		bottomRight thread2 = new bottomRight();
		topRight thread3 = new topRight();
		center thread4 = new center();

		throw new UnsupportedOperationException();

	}

	public synchronized void updateGlobalResult(int localResult) {
		if (localResult < GLOBALRESULT) {
			localResult = GLOBALRESULT;
		}

	}

	private class lowerLeft implements Runnable {

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
			return result;
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
			return result;
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
			return result;
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
			return result;
		}

	}

}
