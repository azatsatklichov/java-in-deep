package net.sahet.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
	public static void main(String[] args) {
		System.out.println("\n	Iterator design pattern example ");

		ChannelList channels = getChannels();
		ChannelIterator baseIterator = channels.iterator(TvChannelEnum.ALL);
		while (baseIterator.hasNext()) {
			Channel c = baseIterator.next();
			System.out.println(c.toString());
		}
		System.out.println();
		ChannelIterator englishIterator = channels.iterator(TvChannelEnum.ENGLISH);
		while (englishIterator.hasNext()) {
			Channel c = englishIterator.next();
			System.out.println(c.toString());
		}

		System.out.println("\n	Iterator Java build-in classes ");

		/**
		 * java.util.Iterator - FAIL FAST
		 * 
		 * java.util.Enumeration - FAIL SAFE
		 * 
		 */
		String[] arr = new String[] { "Ala", "Mula", "Mele" };
		List<String> list = new ArrayList<>(Arrays.asList(arr));

		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			System.out.println(it.next());
			it.remove(); // FAIL FAST
		}
		System.out.println(list);
		System.out.println();

		list = new ArrayList<>(Arrays.asList(arr));
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			System.out.println(name);
			// error prone, un predictable behavior regarding to get(Object), get(idx)
			list.remove(name);
			// list.remove(i);
		}
		System.out.println(list);
		System.out.println();

		list = new ArrayList<>(Arrays.asList(arr));
		for (String name : list) {
			System.out.println(name);
			// Here FAIL FAST works
			// Exception in thread "main" java.util.ConcurrentModificationException
			list.remove(name);
		}
		System.out.println(list);

	}

	private static ChannelList getChannels() {
		ChannelList channels = new ChannelListImpl();
		channels.addChannel(new Channel(108.5, TvChannelEnum.ENGLISH));
		channels.addChannel(new Channel(109.5, TvChannelEnum.TURKMEN));
		channels.addChannel(new Channel(110.5, TvChannelEnum.UZBEK));
		channels.addChannel(new Channel(201.5, TvChannelEnum.ENGLISH));
		channels.addChannel(new Channel(102.5, TvChannelEnum.CZECH));
		channels.addChannel(new Channel(103.5, TvChannelEnum.RUSSIAN));
		channels.addChannel(new Channel(104.5, TvChannelEnum.ENGLISH));
		channels.addChannel(new Channel(105.5, TvChannelEnum.TURKMEN));
		return channels;
	}
}
