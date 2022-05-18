import com.backinfile.support.Utils;
import org.junit.jupiter.api.Test;

public class FormatTest {
    @Test
    public void test1() {
        assert Utils.format("#{0}-{1}#", 123, 4556).equals("#123-4556#");
        assert Utils.format("#{}-{}#", 123, 4556).equals("#123-4556#");
        assert Utils.format("#{1}-{0}#", 123, 4556).equals("#4556-123#");
        assert Utils.format("#{1}-{0}#").equals("#{1}-{0}#");
        assert Utils.format("#{1}-{0}#", 1234).equals("#{1}-1234#");
        assert Utils.format("#{1}-{}#", 1234, 5678).equals("#5678-5678#");
        assert Utils.format("#{1}-{}#", 1234, 5678).equals("#5678-5678#");
        assert Utils.format("{}-{{lalala}}", 1234, 5678).equals("1234-{lalala}");
        assert Utils.format("asd{{lalala}}#").equals("asd{lalala}#");
    }
}
