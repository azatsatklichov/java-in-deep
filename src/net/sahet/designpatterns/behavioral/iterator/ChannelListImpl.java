package net.sahet.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelListImpl implements ChannelList {

	private List<Channel> channelsList;

	public ChannelListImpl() {
		channelsList = new ArrayList<>();
	}

	public void addChannel(Channel c) {
		this.channelsList.add(c);
	}

	public void removeChannel(Channel c) {
		this.channelsList.remove(c);
	}

	private class ChannelIteratorImpl implements ChannelIterator {

		private TvChannelEnum type;
		private List<Channel> channels;
		private int position;

		public ChannelIteratorImpl(TvChannelEnum ty, List<Channel> channelsList) {
			this.type = ty;
			this.channels = channelsList;
		}

		@Override
		public boolean hasNext() {
			while (position < channels.size()) {
				Channel c = channels.get(position);
				if (c.getTvType().equals(type) || type.equals(TvChannelEnum.ALL)) {
					return true;
				} else
					position++;
			}
			return false;
		}

		@Override
		public Channel next() {
			Channel c = channels.get(position);
			position++;
			return c;
		}

	}

	@Override
	public ChannelIterator iterator(TvChannelEnum type) {
		return new ChannelIteratorImpl(type, this.channelsList);
	}

}