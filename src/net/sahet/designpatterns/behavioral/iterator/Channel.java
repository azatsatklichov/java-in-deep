package net.sahet.designpatterns.behavioral.iterator;

public class Channel {

	private double frequency;
	private TvChannelEnum tvType;

	public Channel(double freq, TvChannelEnum tvType) {
		this.frequency = freq;
		this.tvType = tvType;
	}

	public double getFrequency() {
		return frequency;
	}

	public TvChannelEnum getTvType() {
		return tvType;
	}

	@Override
	public String toString() {
		return "Frequency=" + this.frequency + ", Type=" + this.tvType;
	}

}