package logica;


public class Pixel {
	private int r;
	private int g;
	private int b;

	public Pixel(int r, int g, int b) {
		if ((!validate(r)) || (!validate(g)) || (!validate(b)))
			throw new RuntimeException("valores entre 0 y 255 ");
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public int getR() {
		return this.r;
	}

	public void setR(int r) {
		if (!validate(r))
			throw new RuntimeException("valores entre 0 y 255 ");
		this.r = r;
	}

	public int getG() {
		return this.g;
	}

	public void setG(int g) {
		if (!validate(g))
			throw new RuntimeException("valores entre 0 y 255 ");
		this.g = g;
	}

	public int getB() {
		return this.b;
	}

	public void setB(int b) {
		if (!validate(b))
			throw new RuntimeException("valores entre 0 y 255 ");
		this.b = b;
	}

	private boolean validate(int v) {
		if ((v >= 0) && (v < 256))
			return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (getClass() != o.getClass())
			return false;
		final Pixel other = (Pixel) o;
		if (other.r != this.r)
			return false;
		if (other.g != this.g)
			return false;
		if (other.b != this.b)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pixel [r=" + r + ", g=" + g + ", b=" + b + "]";
	}
}
