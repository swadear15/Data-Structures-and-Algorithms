import java.util.Iterator;
import java.util.NoSuchElementException;

public class BusFilteredIterator implements Iterator<Bus> {
	private Iterator<Bus> baseIterator;
	private BusStop destination;
	private Bus next;

	public BusFilteredIterator(Iterator<Bus> iterator, BusStop destination) {
		this.baseIterator = iterator;
		this.destination = destination;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return next != null;
	}

	@Override
	public Bus next() {
		// TODO Auto-generated method stub
		if (!hasNext()) {
			throw new NoSuchElementException("No Bus remain");
		}
		goNext();
		return next;
	}

	private void goNext() {
		while (baseIterator.hasNext()) {// save bus into temp
			Bus temp = baseIterator.next();
			if (temp.goesTo(destination)) {
				next = temp;
				break;
			} else {
				next = null;
			}
		}
	}

}
