class Solution {
	public String solution(String new_id) {
		// #1
		new_id = new_id.toLowerCase();

		// #2
		new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

		// #3
		new_id = new_id.replaceAll("[.]+", ".");

		// #4
		if (new_id.startsWith("."))
			new_id = new_id.substring(1, new_id.length());
		else if (new_id.endsWith("."))
			new_id = new_id.substring(0, new_id.length() - 1);

		// #5
		if (new_id.length() == 0)
			new_id += "a";

		// #6 - 1
		if (new_id.length() >= 16)
			new_id = new_id.substring(0, 15);

		// #6 - 2
		if (new_id.endsWith("."))
			new_id = new_id.substring(0, new_id.length() - 1);

		// #7
		if (new_id.length() <= 2) {
			while (new_id.length() < 3)
				new_id += new_id.charAt(new_id.length() - 1);
		}

		return new_id;
	}
}
