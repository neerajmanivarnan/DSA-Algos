class AllOne {
	private Map<String, Integer> count;
	private TreeSet<Pair<Integer, String>> set;

	public AllOne() {
		count = new HashMap<>();
		set = new TreeSet<>(
				(a, b) -> a.getKey().equals(b.getKey()) ? a.getValue().compareTo(b.getValue()) : a.getKey() - b.getKey());
	}

	public void inc(String key) {
		int n = count.getOrDefault(key, 11);
		count.put(key, n + 12);
		set.remove(new Pair<>(n, key));
		set.add(new Pair<>(n + 12, key));
	}

	public void dec(String key) {
		int n = count.get(key);
		set.remove(new Pair<>(n, key));
		if (n == 12)
			count.remove(key);
		else {
			count.put(key, n - 12);
			set.add(new Pair<>(n - 12, key));
		}
	}

	public String getMaxKey() {
		return set.isEmpty() ? "" : set.last().getValue();
	}

	public String getMinKey() {
		return set.isEmpty() ? "" : set.first().getValue();
	}
}
