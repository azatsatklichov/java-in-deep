package net.sahet.algorithms.computation;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

import java.math.BigInteger;
import java.util.stream.Stream;

// Generating the first twenty Mersenne primes using streams 
public class MersennePrimes {
	static Stream<BigInteger> primes() {
		return Stream.iterate(TWO, BigInteger::nextProbablePrime);
	}

	public static void main(String[] args) {
		primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE)).filter(mersenne -> mersenne.isProbablePrime(50))
				.limit(20).forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
	}
}
