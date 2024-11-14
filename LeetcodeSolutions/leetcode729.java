import java.util.TreeMap;

class MyCalendar {
  private TreeMap<Integer, Integer> calendar;

  public MyCalendar() {
    calendar = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    Integer prev = calendar.floorKey(start);
    Integer next = calendar.ceilingKey(start);

    if ((prev == null || calendar.get(prev) <= start) &&
        (next == null || next >= end)) {
      calendar.put(start, end);
      return true;
    }
    return false;
  }
}
