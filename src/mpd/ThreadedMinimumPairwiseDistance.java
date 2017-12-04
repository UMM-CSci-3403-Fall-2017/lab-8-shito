package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {
	public final int GLOBALRESULT = Integer.MAX_VALUE;
	
	@Override
	public int minimumPairwiseDistance(int[] values) {
		
		Thread[] threads = new Thread[values.length];
		throw new UnsupportedOperationException();

	}
	private int updateGlobalResult(int localResult){
		if(localResult < GLOBALRESULT){
			localResult = GLOBALRESULT;
		}
		
		return localResult;
	}
	
	private class lowerLeft implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class bottomRight implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class topRight implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class center implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
