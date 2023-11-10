package net.sahet.practical.java;

public class ArrayInvariancy {

}

// compilation OK
class Zippy {
	String[] x;
	int[] a[] = { { 1, 2 }, { 1 } };
	Object c = new long[4];
	Object c2 = new long[] { 2, 3 }[0];
	long c3 = new long[] { 2, 3 }[0];
	Object[] d = x;
	// Integer[] i = x;
	Short[] ss = {3,3,3};
	//Integer[] i = ss;
	Integer[] ii = new Integer[2];
	Object xx = ii;
	String[] sta = { "sd", "as" };
	Object obA = sta;
}
