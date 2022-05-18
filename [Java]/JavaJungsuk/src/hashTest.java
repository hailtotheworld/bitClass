import java.util.Objects;

public class hashTest {
	public static void main(String[] args) {
		aa aa = new aa();
		bb bb = new bb();
		
		// 주소를 비교해준다.
		System.out.println(System.identityHashCode(aa));
		System.out.println(System.identityHashCode(bb));
		
		
		System.out.println(aa.hashCode()==bb.hashCode());
	}

}

class aa {
	int x=5;

	// 값을비교해준다.
	@Override
	public int hashCode() {
		return Objects.hash(x);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		aa other = (aa) obj;
		if (x != other.x)
			return false;
		return true;
	}
	
	
	
}

class bb {
	int x=5;
	
	@Override
	public int hashCode() {
		return Objects.hash(x);
	}
	
}