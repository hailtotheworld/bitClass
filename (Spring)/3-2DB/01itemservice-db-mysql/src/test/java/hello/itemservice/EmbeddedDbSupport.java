package hello.itemservice;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.Charset;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.distribution.Version;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.TimeZone;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public abstract class EmbeddedDbSupport {

    private static EmbeddedMysql server;
    private static String USER = "newuser";
    private static String KEY = "0000";

    static {
        MysqldConfig config = MysqldConfig.aMysqldConfig(Version.v5_7_latest)
                .withCharset(Charset.aCharset("utf8mb4", "utf8mb4_bin"))
                .withPort(3307)
                .withUser(USER, KEY)
                .withTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()))
                .withServerVariable("sql_mode", "ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION")
                .withServerVariable("max_connect_errors", 666)
                .build();

        server = EmbeddedMysql.anEmbeddedMysql(config)
                .addSchema("2311dbtestcase")
                .start();
    }


//    Command exited with error code: '-1073741515' and output:
}
