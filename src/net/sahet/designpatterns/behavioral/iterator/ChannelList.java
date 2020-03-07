package net.sahet.designpatterns.behavioral.iterator;

public interface ChannelList {

	public void addChannel(Channel c);

	public void removeChannel(Channel c);

	public ChannelIterator iterator(TvChannelEnum type);

}