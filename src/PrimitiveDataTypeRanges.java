package net.sahet.iviews;

/**
 * <p>
 * <h1 align="center">Java's Primitive Data Types</h1>
 * </p>
 * 
 * <dl>
 * <dt><code>boolean</code></dt>
 * 
 * <dd>
 * <p>
 * 1-bit. May take on the values <code>true</code> and <code>false</code> only.
 * </p>
 * 
 * <p>
 * <code>true</code> and <code>false</code> are defined constants of the
 * language and are not the same as <code>True</code> and <code>False</code>,
 * <code>TRUE</code> and <code>FALSE</code>, zero and nonzero, 1 and 0 or any
 * other numeric value. Booleans may not be cast into any other type of variable
 * nor may any other variable be cast into a boolean.
 * </p>
 * 
 * 
 * </dd>
 * 
 * <dt><code>byte</code></dt>
 * 
 * <dd>
 * <p>
 * 1 signed byte (two's complement). Covers values from -128 to 127.
 * </p>
 * 
 * 
 * 
 * </dd>
 * 
 * <dt><code>short</code></dt>
 * 
 * <dd>
 * <p>
 * 2 bytes, signed (two's complement), -32,768 to 32,767
 * </p>
 * 
 * 
 * </dd>
 * 
 * <dt><code>int</code></dt>
 * 
 * <dd>
 * <p>
 * 4 bytes, signed (two's complement). -2,147,483,648 to 2,147,483,647. Like all
 * numeric types ints may be cast into other numeric types (byte, short, long,
 * float, double). When <em>lossy</em> casts are done (e.g. int to byte) the
 * conversion is done modulo the length of the smaller type.
 * </p>
 * 
 * 
 * 
 * </dd>
 * 
 * <dt><code>long</code></dt>
 * 
 * <dd>
 * <p>
 * 8 bytes signed (two's complement). Ranges from -9,223,372,036,854,775,808 to
 * +9,223,372,036,854,775,807.
 * </p>
 * 
 * 
 * </dd>
 * 
 * <dt><code>float</code></dt>
 * 
 * <dd>
 * <p>
 * 4 bytes, IEEE 754. Covers a range from 1.40129846432481707e-45 to
 * 3.40282346638528860e+38 (positive or negative).
 * </p>
 * 
 * <p>
 * Like all numeric types floats may be cast into other numeric types (
 * <code>byte</code>, <code>short</code>, <code>long</code>, <code>int</code>,
 * <code>double</code>). When <i>lossy</i> casts to integer types are done (e.g.
 * <code>float</code> to <code>short</code>) the fractional part is truncated
 * and the conversion is done modulo the length of the smaller type.
 * </p>
 * 
 * 
 * </dd>
 * 
 * <dt><code>double</code></dt>
 * 
 * <dd>8 bytes IEEE 754. Covers a range from 4.94065645841246544e-324d to
 * 1.79769313486231570e+308d (positive or negative).
 * 
 * 
 * or 2^-1074 <= x <= (2-2^-52)·2^1023 // where x is the double.
 * 
 * </dd>
 * 
 * <dt><code>char</code></dt>
 * 
 * <dd>
 * <p>
 * 2 bytes, unsigned, Unicode, 0 to 65,535
 * </p>
 * 
 * 
 * <p>
 * Chars are not the same as bytes, ints, shorts or Strings.
 * </p>
 */
public class PrimitiveDataTypeRanges {

	public static void main(String[] args) {
		char defValue = '\u0000';
		//char is 2 bytes, byte is 1 byte  
		System.out.println("char defValue  = " + defValue);

		 defValue = ' ';
		System.out.println("char defValue  = " + defValue);
	
	}

}
