
package net.sahet.designpatterns.behavioral.chainofresponsibility;

//From Thinking in Java 
class LineData {
	public double[] data;

	public LineData(double[] data) {
		this.data = data;
	}

	private boolean succeeded;

	public boolean isSuccessful() {
		return succeeded;
	}

	public void setSuccessful(boolean b) {
		succeeded = b;
	}
}

interface Strategy {
	LineData strategy(LineData m);
}

class LeastSquares implements Strategy {
	public LineData strategy(LineData m) {
		System.out.println("Trying LeastSquares algorithm");
		LineData ld = (LineData) m;
		LineData r = new LineData(new double[] { 1.1, 2.2 });
		r.setSuccessful(false);
		return r;
	}
}

class NewtonsMethod implements Strategy {
	public LineData strategy(LineData m) {
		System.out.println("Trying NewtonsMethod algorithm");
		LineData ld = (LineData) m;
		LineData r = new LineData(new double[] { 3.3, 4.4 });
		r.setSuccessful(false);
		return r;
	}
}

class Bisection implements Strategy {
	public LineData strategy(LineData m) {
		System.out.println("Trying Bisection algorithm");
		LineData ld = (LineData) m;
		LineData r = new LineData(new double[] { 5.5, 6.6 });
		r.setSuccessful(true);
		return r;
	}
}

class ConjugateGradient implements Strategy {
	public LineData strategy(LineData m) {
		System.out.println("Trying ConjugateGradient algorithm");
		LineData ld = (LineData) m;
		LineData r = new LineData(new double[] { 5.5, 6.6 });
		r.setSuccessful(true);
		return r;
	}
}

class MinimaFinder {
	private static Strategy[] solutions = { new LeastSquares(), new NewtonsMethod(), new Bisection(),
			new ConjugateGradient(), };

	public static LineData solve(LineData line) {
		LineData r = line;
		for (int i = 0; i < solutions.length; i++) {
			r = solutions[i].strategy(r);
			if (r.isSuccessful())
				return r;
		}
		throw new RuntimeException("unsolved: " + line);
	}
}
