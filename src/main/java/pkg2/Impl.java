package pkg2;

public class Impl extends AbstractBase {
	Impl() {
	}
	Impl(AbstractBase b) {
		b.a();
	}

	@Override
	public String a() {
		return null;
	}

	public static void main(String[] args) {
		Impl impl = new Impl();
		new Impl(impl);
	}
}
