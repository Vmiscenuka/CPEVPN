package secure.cpe.vpn

import android.content.Context
import java.util.Date
import kotlin.random.Random

object Config {

    val serverList = mutableListOf(
        ServerModel(
            0,
            "Belarus",
            "54.240.1.54",
            R.drawable.fl_belarus,

            "client\n" +
                    "dev tun\n" +
                    "proto tcp\n" +
                    "remote 38.180.61.53 943\n" +
                    "resolv-retry infinite\n" +
                    "nobind\n" +
                    "persist-key\n" +
                    "persist-tun\n" +
                    "remote-cert-tls server\n" +
                    "auth SHA512\n" +
                    "ignore-unknown-option block-outside-dns\n" +
                    "verb 3\n" +
                    "<ca>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDSzCCAjOgAwIBAgIUT6IyRhA5k4KJX023J0kxqvQ/UHgwDQYJKoZIhvcNAQEL\n" +
                    "BQAwFjEUMBIGA1UEAwwLRWFzeS1SU0EgQ0EwHhcNMjQwMjAxMTQyNTMxWhcNMzQw\n" +
                    "MTI5MTQyNTMxWjAWMRQwEgYDVQQDDAtFYXN5LVJTQSBDQTCCASIwDQYJKoZIhvcN\n" +
                    "AQEBBQADggEPADCCAQoCggEBAPXSwGP/+aU+Y1N0ID/7wUaK9erZujZpZzL33/Q1\n" +
                    "bbdsR0My4sr1OzvzsCp/xamQkNEQRtRJR1gQ0V/Kt0xPU01TRystmbzLcTBknZDI\n" +
                    "xWRi7zrr9pYiMgThF0M8ZWxsIcg3gxKQH+cG+9elrOtGBDBMSzL25TiaWBMZVnTi\n" +
                    "71Qndps58nzrw2Rj83jqyJUp1KLhlNjCRrmtbmeX2vphpXdLJuFfjTB3v5+O+kcV\n" +
                    "GAppzrIdiRqblFt0dfgi5ez0Ou7OAv6yyZkgNDwpd2zWvRkvX5XyHvfR6mUbm6C1\n" +
                    "GZOUUi+yWdvhPnMa++jIJOPWbSZzOOXRpm+RVpCL1mvHTykCAwEAAaOBkDCBjTAM\n" +
                    "BgNVHRMEBTADAQH/MB0GA1UdDgQWBBTa0Bbct/9Kt3LuUZlbxnjfbh5/xzBRBgNV\n" +
                    "HSMESjBIgBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFz\n" +
                    "eS1SU0EgQ0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MAsGA1UdDwQEAwIBBjANBgkq\n" +
                    "hkiG9w0BAQsFAAOCAQEAEcXuSouJCqI4Fe4zuonk5n91zSMzQJSKAOtxkCW23mtE\n" +
                    "9OoWgKuyUjFTPSvlZpZ55/P8/KCKdQyyRmE7Hixvz2DKosbusvFiZIBrKiwAoBtR\n" +
                    "++CYhQnWIE8+p1TRTlWsgLFo/dfU82OEIgRPqnhNwR2T3xpnKvpgfazgVY12qQPf\n" +
                    "hwzrpnT8W90sv6PiO/CsMeaG95n899KyNqjjUJVat0YSehbA0nqdb7VWc157IpOn\n" +
                    "BVkRvOlIwkL7Xcjr0KiIlTkaIMDMw7lDBJG6eR0SNUGLxiGdeIg9FxWjRe0nBXwO\n" +
                    "d0gDWKiYurcJ1FW3l3LB8RFoT9Z/38cu4zIbeET/DQ==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</ca>\n" +
                    "<cert>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDWjCCAkKgAwIBAgIQUFOAPLGi/ZlB+5TCJVYJAzANBgkqhkiG9w0BAQsFADAW\n" +
                    "MRQwEgYDVQQDDAtFYXN5LVJTQSBDQTAeFw0yNDAyMDExNDI1MzFaFw0zNDAxMjkx\n" +
                    "NDI1MzFaMBcxFTATBgNVBAMMDHVuaXRlZHN0YXRlczCCASIwDQYJKoZIhvcNAQEB\n" +
                    "BQADggEPADCCAQoCggEBAMIW5U0pDXI2b2hRiAvvIUdVo2W0+jRs05XZpVOPBaNu\n" +
                    "4+p1oS7DEnfft7IRd5C6aVUyiPi4/ELgceV6N33Gw+0gboKAAQ9152gqM+ul/YdW\n" +
                    "ZZwMiM0/NPjZX28wMSDRvizfjKHSaNxu5YoWMmbOLqNFX6l9O6I7P9WPd5fP32e3\n" +
                    "uQ6mv9XOa0oW2E9tRPOgkl4rfoSPcceVN9jegMnPQ/HniYBu67aQcaRySXSXJGD2\n" +
                    "qs2ymovhe1fGmB+9qukMbyeBc1KcZjxvCSU2XqizhweW+9XleJZnuY0/Df+aHHPH\n" +
                    "pSWNmE6D4TPa4fO+y01jMkBrsGyrHGaDWqviV0XsFVsCAwEAAaOBojCBnzAJBgNV\n" +
                    "HRMEAjAAMB0GA1UdDgQWBBShaCd+G3bz4xSAIuGMJoCH4k3jWzBRBgNVHSMESjBI\n" +
                    "gBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFzeS1SU0Eg\n" +
                    "Q0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MBMGA1UdJQQMMAoGCCsGAQUFBwMCMAsG\n" +
                    "A1UdDwQEAwIHgDANBgkqhkiG9w0BAQsFAAOCAQEAk1JY5m44+mSM+Eq3bNEYZ1Hz\n" +
                    "kFz+oN3NesemC8HSCbDIMk4N4nxKczgmlSDFxhCdMChBlmSoidUYwis889Jp90gp\n" +
                    "IS/jZbFAR2k+1nj8lZgSWr5bLL0onIu3XwSevhlFaZaT5Slcl952PWvSr9GnYBD2\n" +
                    "MSAaOZfWOYZGlTJl2cZpqLc+OPo+GDsQd3ERfCaR4fmYEgk7Y7rKzBUt+BD4QAhA\n" +
                    "4C4VHnBvfPk9/SB+B4jslGql5lbhdF2drLSQS06z623+E804bX4PZg7IYe6Fz1fW\n" +
                    "5Oc2i87sagXb0eYRB28fpUMRcGi+GtBC2kc8/3pPmvWeY5QO5B1yj/X//fxDRg==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</cert>\n" +
                    "<key>\n" +
                    "-----BEGIN PRIVATE KEY-----\n" +
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDCFuVNKQ1yNm9o\n" +
                    "UYgL7yFHVaNltPo0bNOV2aVTjwWjbuPqdaEuwxJ337eyEXeQumlVMoj4uPxC4HHl\n" +
                    "ejd9xsPtIG6CgAEPdedoKjPrpf2HVmWcDIjNPzT42V9vMDEg0b4s34yh0mjcbuWK\n" +
                    "FjJmzi6jRV+pfTuiOz/Vj3eXz99nt7kOpr/VzmtKFthPbUTzoJJeK36Ej3HHlTfY\n" +
                    "3oDJz0Px54mAbuu2kHGkckl0lyRg9qrNspqL4XtXxpgfvarpDG8ngXNSnGY8bwkl\n" +
                    "Nl6os4cHlvvV5XiWZ7mNPw3/mhxzx6UljZhOg+Ez2uHzvstNYzJAa7Bsqxxmg1qr\n" +
                    "4ldF7BVbAgMBAAECggEAFJFakVe1XhIYskRZl3Iq46VWoHOSRDX4IhwjYfx5C323\n" +
                    "12PJxevULDHgBJXHRuYKPYYSb9Eiom+ogjn2YXTL1HgoXdn0ws+qyyYVxHYdrNbi\n" +
                    "A6xsXtvA4FIgw+amfiTb82NpQsjKZfm2h3CcvLpCxPiYD5z+0c1XkWkXslXMBfCJ\n" +
                    "3HMM1NostSYIkzGEglbPH3B3iRWeng9xe20QsnjGSTc+Cet0tlCZZvGrr0wemxjy\n" +
                    "Wi136wi7iKEMjF75E4L4AnGT7/Lpl9pHOlJ0i8nv6dhXTZNH4otlGTBscxxZi5FB\n" +
                    "mWbEnUYlS+E0QJjPEBN5T0ucScY16XS14bPdEPQEiQKBgQDxzCaCuSjuhCobG6oP\n" +
                    "FFvU74iSj7QYOsxYlVGLSij0W8aVeLcVHF/vr9sI3/9gDy8tsDkBDDuWStT6jixZ\n" +
                    "bAmc0uHN5GJ4wReojxNTemkj0eqQ1Q5L+usfspw+vTYODVfVsnrYU92loFEn93Le\n" +
                    "Ffl0mi5p7UWq39hrAE98Pe7SJwKBgQDNfV8NrOItSe8I3pwvgB5QUHZbjSk2GfXS\n" +
                    "lqbxBMY90dxrTnkdRfzD4TxwuN8PSW2kSznmcit1T7btGWsTsPvDDgzHGibZu6G5\n" +
                    "GsZOXpj8fGaGItd9MStMdg9OFBnLPgtbm5tbPH31nPS6sXdl+j2kChlQeQmrx19u\n" +
                    "rZxDgI8HrQKBgQCv78HdwGieFKCmlNyKmF+xcpFHQzThpHbnxc5NsapXEyhNvkZJ\n" +
                    "IBpWRvjzXjltZd8IOX9g2cvJsa2Cmkx+zHO6Hl+a9qEICEf0qBaB2UIDhExPEheT\n" +
                    "BYJr0ASMShS46NCOd42XNn7CcwJaOFzmZ8rZIw6+mJzmlnXcdZ9gYZgSZQKBgETo\n" +
                    "iuySEhKv3VmzFNsU8pVqNhaDYtOCpx2kaX0fZb8rVegiG5lGc/nX2SXPyPVeYUcb\n" +
                    "9uGhXZNsVOJziKXEzthdKMnHqkmPky74nJGBRXo92T+YBX009NkiKgW71d6DAtoI\n" +
                    "d3OD+JVZufO1OV3YKb2NqWmD/Us+g3EhBOrZ/JzNAoGAAOnUfitSvZHwYxbBl2Zl\n" +
                    "1oueDdUGgI0gVN7OA80GuN1J30mbh3zISSJRiXUz9zptTOnBknP08yHVNkQuKse+\n" +
                    "fnlYaow6iCrIZyDb8jIyVqaiGx2HICvajDB59n1zMuOXbfRCvxhfbz76g8oWuj0i\n" +
                    "7Bndhd60D/bNBsq8nEEfbN4=\n" +
                    "-----END PRIVATE KEY-----\n" +
                    "</key>\n" +
                    "<tls-crypt>\n" +
                    "-----BEGIN OpenVPN Static key V1-----\n" +
                    "df167a48c5db52ec2c5a4dd05c62743c\n" +
                    "3231fc80a09b5bb646766f5ff2c060a8\n" +
                    "3c3f92e1f445b2b7dbe639b7cb0f3509\n" +
                    "316d20379a9255a7c81900ecc748497d\n" +
                    "3560f33275e18262b6198c0f0530bd3a\n" +
                    "9ee02afe0502042e65e4da4d2669dd41\n" +
                    "10ec4e622a7d758b6492d6fd776cb0b7\n" +
                    "749fc38239f5e736d1b8411f6eb0ae63\n" +
                    "1bab148e11eb9c963cdcc6620f12d16e\n" +
                    "ab8ab8dd37976c3ae7d503e21dd0f5af\n" +
                    "23bb104d10e46eb6fa053cd1af73efa4\n" +
                    "b68f529bfbc634a531659e86744d065b\n" +
                    "0c547c8dc9265f92df57be82c4364bcd\n" +
                    "7fb02a14ea626f3d4a278bb29f028d87\n" +
                    "306a63fb3ff38137c683e02f50e982c6\n" +
                    "0a04e75ef67c3663c8ef18bc8bd0b13e\n" +
                    "-----END OpenVPN Static key V1-----\n" +
                    "</tls-crypt>\n"
        ),
        ServerModel(
            1,
            "Cyprus",
            "172.217.20.110",
            R.drawable.fl_cyprus,
            "client\n" +
                    "dev tun\n" +
                    "proto tcp\n" +
                    "remote 38.180.61.53 943\n" +
                    "resolv-retry infinite\n" +
                    "nobind\n" +
                    "persist-key\n" +
                    "persist-tun\n" +
                    "remote-cert-tls server\n" +
                    "auth SHA512\n" +
                    "ignore-unknown-option block-outside-dns\n" +
                    "verb 3\n" +
                    "<ca>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDSzCCAjOgAwIBAgIUT6IyRhA5k4KJX023J0kxqvQ/UHgwDQYJKoZIhvcNAQEL\n" +
                    "BQAwFjEUMBIGA1UEAwwLRWFzeS1SU0EgQ0EwHhcNMjQwMjAxMTQyNTMxWhcNMzQw\n" +
                    "MTI5MTQyNTMxWjAWMRQwEgYDVQQDDAtFYXN5LVJTQSBDQTCCASIwDQYJKoZIhvcN\n" +
                    "AQEBBQADggEPADCCAQoCggEBAPXSwGP/+aU+Y1N0ID/7wUaK9erZujZpZzL33/Q1\n" +
                    "bbdsR0My4sr1OzvzsCp/xamQkNEQRtRJR1gQ0V/Kt0xPU01TRystmbzLcTBknZDI\n" +
                    "xWRi7zrr9pYiMgThF0M8ZWxsIcg3gxKQH+cG+9elrOtGBDBMSzL25TiaWBMZVnTi\n" +
                    "71Qndps58nzrw2Rj83jqyJUp1KLhlNjCRrmtbmeX2vphpXdLJuFfjTB3v5+O+kcV\n" +
                    "GAppzrIdiRqblFt0dfgi5ez0Ou7OAv6yyZkgNDwpd2zWvRkvX5XyHvfR6mUbm6C1\n" +
                    "GZOUUi+yWdvhPnMa++jIJOPWbSZzOOXRpm+RVpCL1mvHTykCAwEAAaOBkDCBjTAM\n" +
                    "BgNVHRMEBTADAQH/MB0GA1UdDgQWBBTa0Bbct/9Kt3LuUZlbxnjfbh5/xzBRBgNV\n" +
                    "HSMESjBIgBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFz\n" +
                    "eS1SU0EgQ0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MAsGA1UdDwQEAwIBBjANBgkq\n" +
                    "hkiG9w0BAQsFAAOCAQEAEcXuSouJCqI4Fe4zuonk5n91zSMzQJSKAOtxkCW23mtE\n" +
                    "9OoWgKuyUjFTPSvlZpZ55/P8/KCKdQyyRmE7Hixvz2DKosbusvFiZIBrKiwAoBtR\n" +
                    "++CYhQnWIE8+p1TRTlWsgLFo/dfU82OEIgRPqnhNwR2T3xpnKvpgfazgVY12qQPf\n" +
                    "hwzrpnT8W90sv6PiO/CsMeaG95n899KyNqjjUJVat0YSehbA0nqdb7VWc157IpOn\n" +
                    "BVkRvOlIwkL7Xcjr0KiIlTkaIMDMw7lDBJG6eR0SNUGLxiGdeIg9FxWjRe0nBXwO\n" +
                    "d0gDWKiYurcJ1FW3l3LB8RFoT9Z/38cu4zIbeET/DQ==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</ca>\n" +
                    "<cert>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDWjCCAkKgAwIBAgIQUFOAPLGi/ZlB+5TCJVYJAzANBgkqhkiG9w0BAQsFADAW\n" +
                    "MRQwEgYDVQQDDAtFYXN5LVJTQSBDQTAeFw0yNDAyMDExNDI1MzFaFw0zNDAxMjkx\n" +
                    "NDI1MzFaMBcxFTATBgNVBAMMDHVuaXRlZHN0YXRlczCCASIwDQYJKoZIhvcNAQEB\n" +
                    "BQADggEPADCCAQoCggEBAMIW5U0pDXI2b2hRiAvvIUdVo2W0+jRs05XZpVOPBaNu\n" +
                    "4+p1oS7DEnfft7IRd5C6aVUyiPi4/ELgceV6N33Gw+0gboKAAQ9152gqM+ul/YdW\n" +
                    "ZZwMiM0/NPjZX28wMSDRvizfjKHSaNxu5YoWMmbOLqNFX6l9O6I7P9WPd5fP32e3\n" +
                    "uQ6mv9XOa0oW2E9tRPOgkl4rfoSPcceVN9jegMnPQ/HniYBu67aQcaRySXSXJGD2\n" +
                    "qs2ymovhe1fGmB+9qukMbyeBc1KcZjxvCSU2XqizhweW+9XleJZnuY0/Df+aHHPH\n" +
                    "pSWNmE6D4TPa4fO+y01jMkBrsGyrHGaDWqviV0XsFVsCAwEAAaOBojCBnzAJBgNV\n" +
                    "HRMEAjAAMB0GA1UdDgQWBBShaCd+G3bz4xSAIuGMJoCH4k3jWzBRBgNVHSMESjBI\n" +
                    "gBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFzeS1SU0Eg\n" +
                    "Q0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MBMGA1UdJQQMMAoGCCsGAQUFBwMCMAsG\n" +
                    "A1UdDwQEAwIHgDANBgkqhkiG9w0BAQsFAAOCAQEAk1JY5m44+mSM+Eq3bNEYZ1Hz\n" +
                    "kFz+oN3NesemC8HSCbDIMk4N4nxKczgmlSDFxhCdMChBlmSoidUYwis889Jp90gp\n" +
                    "IS/jZbFAR2k+1nj8lZgSWr5bLL0onIu3XwSevhlFaZaT5Slcl952PWvSr9GnYBD2\n" +
                    "MSAaOZfWOYZGlTJl2cZpqLc+OPo+GDsQd3ERfCaR4fmYEgk7Y7rKzBUt+BD4QAhA\n" +
                    "4C4VHnBvfPk9/SB+B4jslGql5lbhdF2drLSQS06z623+E804bX4PZg7IYe6Fz1fW\n" +
                    "5Oc2i87sagXb0eYRB28fpUMRcGi+GtBC2kc8/3pPmvWeY5QO5B1yj/X//fxDRg==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</cert>\n" +
                    "<key>\n" +
                    "-----BEGIN PRIVATE KEY-----\n" +
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDCFuVNKQ1yNm9o\n" +
                    "UYgL7yFHVaNltPo0bNOV2aVTjwWjbuPqdaEuwxJ337eyEXeQumlVMoj4uPxC4HHl\n" +
                    "ejd9xsPtIG6CgAEPdedoKjPrpf2HVmWcDIjNPzT42V9vMDEg0b4s34yh0mjcbuWK\n" +
                    "FjJmzi6jRV+pfTuiOz/Vj3eXz99nt7kOpr/VzmtKFthPbUTzoJJeK36Ej3HHlTfY\n" +
                    "3oDJz0Px54mAbuu2kHGkckl0lyRg9qrNspqL4XtXxpgfvarpDG8ngXNSnGY8bwkl\n" +
                    "Nl6os4cHlvvV5XiWZ7mNPw3/mhxzx6UljZhOg+Ez2uHzvstNYzJAa7Bsqxxmg1qr\n" +
                    "4ldF7BVbAgMBAAECggEAFJFakVe1XhIYskRZl3Iq46VWoHOSRDX4IhwjYfx5C323\n" +
                    "12PJxevULDHgBJXHRuYKPYYSb9Eiom+ogjn2YXTL1HgoXdn0ws+qyyYVxHYdrNbi\n" +
                    "A6xsXtvA4FIgw+amfiTb82NpQsjKZfm2h3CcvLpCxPiYD5z+0c1XkWkXslXMBfCJ\n" +
                    "3HMM1NostSYIkzGEglbPH3B3iRWeng9xe20QsnjGSTc+Cet0tlCZZvGrr0wemxjy\n" +
                    "Wi136wi7iKEMjF75E4L4AnGT7/Lpl9pHOlJ0i8nv6dhXTZNH4otlGTBscxxZi5FB\n" +
                    "mWbEnUYlS+E0QJjPEBN5T0ucScY16XS14bPdEPQEiQKBgQDxzCaCuSjuhCobG6oP\n" +
                    "FFvU74iSj7QYOsxYlVGLSij0W8aVeLcVHF/vr9sI3/9gDy8tsDkBDDuWStT6jixZ\n" +
                    "bAmc0uHN5GJ4wReojxNTemkj0eqQ1Q5L+usfspw+vTYODVfVsnrYU92loFEn93Le\n" +
                    "Ffl0mi5p7UWq39hrAE98Pe7SJwKBgQDNfV8NrOItSe8I3pwvgB5QUHZbjSk2GfXS\n" +
                    "lqbxBMY90dxrTnkdRfzD4TxwuN8PSW2kSznmcit1T7btGWsTsPvDDgzHGibZu6G5\n" +
                    "GsZOXpj8fGaGItd9MStMdg9OFBnLPgtbm5tbPH31nPS6sXdl+j2kChlQeQmrx19u\n" +
                    "rZxDgI8HrQKBgQCv78HdwGieFKCmlNyKmF+xcpFHQzThpHbnxc5NsapXEyhNvkZJ\n" +
                    "IBpWRvjzXjltZd8IOX9g2cvJsa2Cmkx+zHO6Hl+a9qEICEf0qBaB2UIDhExPEheT\n" +
                    "BYJr0ASMShS46NCOd42XNn7CcwJaOFzmZ8rZIw6+mJzmlnXcdZ9gYZgSZQKBgETo\n" +
                    "iuySEhKv3VmzFNsU8pVqNhaDYtOCpx2kaX0fZb8rVegiG5lGc/nX2SXPyPVeYUcb\n" +
                    "9uGhXZNsVOJziKXEzthdKMnHqkmPky74nJGBRXo92T+YBX009NkiKgW71d6DAtoI\n" +
                    "d3OD+JVZufO1OV3YKb2NqWmD/Us+g3EhBOrZ/JzNAoGAAOnUfitSvZHwYxbBl2Zl\n" +
                    "1oueDdUGgI0gVN7OA80GuN1J30mbh3zISSJRiXUz9zptTOnBknP08yHVNkQuKse+\n" +
                    "fnlYaow6iCrIZyDb8jIyVqaiGx2HICvajDB59n1zMuOXbfRCvxhfbz76g8oWuj0i\n" +
                    "7Bndhd60D/bNBsq8nEEfbN4=\n" +
                    "-----END PRIVATE KEY-----\n" +
                    "</key>\n" +
                    "<tls-crypt>\n" +
                    "-----BEGIN OpenVPN Static key V1-----\n" +
                    "df167a48c5db52ec2c5a4dd05c62743c\n" +
                    "3231fc80a09b5bb646766f5ff2c060a8\n" +
                    "3c3f92e1f445b2b7dbe639b7cb0f3509\n" +
                    "316d20379a9255a7c81900ecc748497d\n" +
                    "3560f33275e18262b6198c0f0530bd3a\n" +
                    "9ee02afe0502042e65e4da4d2669dd41\n" +
                    "10ec4e622a7d758b6492d6fd776cb0b7\n" +
                    "749fc38239f5e736d1b8411f6eb0ae63\n" +
                    "1bab148e11eb9c963cdcc6620f12d16e\n" +
                    "ab8ab8dd37976c3ae7d503e21dd0f5af\n" +
                    "23bb104d10e46eb6fa053cd1af73efa4\n" +
                    "b68f529bfbc634a531659e86744d065b\n" +
                    "0c547c8dc9265f92df57be82c4364bcd\n" +
                    "7fb02a14ea626f3d4a278bb29f028d87\n" +
                    "306a63fb3ff38137c683e02f50e982c6\n" +
                    "0a04e75ef67c3663c8ef18bc8bd0b13e\n" +
                    "-----END OpenVPN Static key V1-----\n" +
                    "</tls-crypt>\n"
        ),
        ServerModel(
            2,
            "Greece",
            "203.128.45.78",
            R.drawable.fl_greece,
            "client\n" +
                    "dev tun\n" +
                    "proto tcp\n" +
                    "remote 38.180.61.53 943\n" +
                    "resolv-retry infinite\n" +
                    "nobind\n" +
                    "persist-key\n" +
                    "persist-tun\n" +
                    "remote-cert-tls server\n" +
                    "auth SHA512\n" +
                    "ignore-unknown-option block-outside-dns\n" +
                    "verb 3\n" +
                    "<ca>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDSzCCAjOgAwIBAgIUT6IyRhA5k4KJX023J0kxqvQ/UHgwDQYJKoZIhvcNAQEL\n" +
                    "BQAwFjEUMBIGA1UEAwwLRWFzeS1SU0EgQ0EwHhcNMjQwMjAxMTQyNTMxWhcNMzQw\n" +
                    "MTI5MTQyNTMxWjAWMRQwEgYDVQQDDAtFYXN5LVJTQSBDQTCCASIwDQYJKoZIhvcN\n" +
                    "AQEBBQADggEPADCCAQoCggEBAPXSwGP/+aU+Y1N0ID/7wUaK9erZujZpZzL33/Q1\n" +
                    "bbdsR0My4sr1OzvzsCp/xamQkNEQRtRJR1gQ0V/Kt0xPU01TRystmbzLcTBknZDI\n" +
                    "xWRi7zrr9pYiMgThF0M8ZWxsIcg3gxKQH+cG+9elrOtGBDBMSzL25TiaWBMZVnTi\n" +
                    "71Qndps58nzrw2Rj83jqyJUp1KLhlNjCRrmtbmeX2vphpXdLJuFfjTB3v5+O+kcV\n" +
                    "GAppzrIdiRqblFt0dfgi5ez0Ou7OAv6yyZkgNDwpd2zWvRkvX5XyHvfR6mUbm6C1\n" +
                    "GZOUUi+yWdvhPnMa++jIJOPWbSZzOOXRpm+RVpCL1mvHTykCAwEAAaOBkDCBjTAM\n" +
                    "BgNVHRMEBTADAQH/MB0GA1UdDgQWBBTa0Bbct/9Kt3LuUZlbxnjfbh5/xzBRBgNV\n" +
                    "HSMESjBIgBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFz\n" +
                    "eS1SU0EgQ0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MAsGA1UdDwQEAwIBBjANBgkq\n" +
                    "hkiG9w0BAQsFAAOCAQEAEcXuSouJCqI4Fe4zuonk5n91zSMzQJSKAOtxkCW23mtE\n" +
                    "9OoWgKuyUjFTPSvlZpZ55/P8/KCKdQyyRmE7Hixvz2DKosbusvFiZIBrKiwAoBtR\n" +
                    "++CYhQnWIE8+p1TRTlWsgLFo/dfU82OEIgRPqnhNwR2T3xpnKvpgfazgVY12qQPf\n" +
                    "hwzrpnT8W90sv6PiO/CsMeaG95n899KyNqjjUJVat0YSehbA0nqdb7VWc157IpOn\n" +
                    "BVkRvOlIwkL7Xcjr0KiIlTkaIMDMw7lDBJG6eR0SNUGLxiGdeIg9FxWjRe0nBXwO\n" +
                    "d0gDWKiYurcJ1FW3l3LB8RFoT9Z/38cu4zIbeET/DQ==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</ca>\n" +
                    "<cert>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDWjCCAkKgAwIBAgIQUFOAPLGi/ZlB+5TCJVYJAzANBgkqhkiG9w0BAQsFADAW\n" +
                    "MRQwEgYDVQQDDAtFYXN5LVJTQSBDQTAeFw0yNDAyMDExNDI1MzFaFw0zNDAxMjkx\n" +
                    "NDI1MzFaMBcxFTATBgNVBAMMDHVuaXRlZHN0YXRlczCCASIwDQYJKoZIhvcNAQEB\n" +
                    "BQADggEPADCCAQoCggEBAMIW5U0pDXI2b2hRiAvvIUdVo2W0+jRs05XZpVOPBaNu\n" +
                    "4+p1oS7DEnfft7IRd5C6aVUyiPi4/ELgceV6N33Gw+0gboKAAQ9152gqM+ul/YdW\n" +
                    "ZZwMiM0/NPjZX28wMSDRvizfjKHSaNxu5YoWMmbOLqNFX6l9O6I7P9WPd5fP32e3\n" +
                    "uQ6mv9XOa0oW2E9tRPOgkl4rfoSPcceVN9jegMnPQ/HniYBu67aQcaRySXSXJGD2\n" +
                    "qs2ymovhe1fGmB+9qukMbyeBc1KcZjxvCSU2XqizhweW+9XleJZnuY0/Df+aHHPH\n" +
                    "pSWNmE6D4TPa4fO+y01jMkBrsGyrHGaDWqviV0XsFVsCAwEAAaOBojCBnzAJBgNV\n" +
                    "HRMEAjAAMB0GA1UdDgQWBBShaCd+G3bz4xSAIuGMJoCH4k3jWzBRBgNVHSMESjBI\n" +
                    "gBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFzeS1SU0Eg\n" +
                    "Q0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MBMGA1UdJQQMMAoGCCsGAQUFBwMCMAsG\n" +
                    "A1UdDwQEAwIHgDANBgkqhkiG9w0BAQsFAAOCAQEAk1JY5m44+mSM+Eq3bNEYZ1Hz\n" +
                    "kFz+oN3NesemC8HSCbDIMk4N4nxKczgmlSDFxhCdMChBlmSoidUYwis889Jp90gp\n" +
                    "IS/jZbFAR2k+1nj8lZgSWr5bLL0onIu3XwSevhlFaZaT5Slcl952PWvSr9GnYBD2\n" +
                    "MSAaOZfWOYZGlTJl2cZpqLc+OPo+GDsQd3ERfCaR4fmYEgk7Y7rKzBUt+BD4QAhA\n" +
                    "4C4VHnBvfPk9/SB+B4jslGql5lbhdF2drLSQS06z623+E804bX4PZg7IYe6Fz1fW\n" +
                    "5Oc2i87sagXb0eYRB28fpUMRcGi+GtBC2kc8/3pPmvWeY5QO5B1yj/X//fxDRg==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</cert>\n" +
                    "<key>\n" +
                    "-----BEGIN PRIVATE KEY-----\n" +
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDCFuVNKQ1yNm9o\n" +
                    "UYgL7yFHVaNltPo0bNOV2aVTjwWjbuPqdaEuwxJ337eyEXeQumlVMoj4uPxC4HHl\n" +
                    "ejd9xsPtIG6CgAEPdedoKjPrpf2HVmWcDIjNPzT42V9vMDEg0b4s34yh0mjcbuWK\n" +
                    "FjJmzi6jRV+pfTuiOz/Vj3eXz99nt7kOpr/VzmtKFthPbUTzoJJeK36Ej3HHlTfY\n" +
                    "3oDJz0Px54mAbuu2kHGkckl0lyRg9qrNspqL4XtXxpgfvarpDG8ngXNSnGY8bwkl\n" +
                    "Nl6os4cHlvvV5XiWZ7mNPw3/mhxzx6UljZhOg+Ez2uHzvstNYzJAa7Bsqxxmg1qr\n" +
                    "4ldF7BVbAgMBAAECggEAFJFakVe1XhIYskRZl3Iq46VWoHOSRDX4IhwjYfx5C323\n" +
                    "12PJxevULDHgBJXHRuYKPYYSb9Eiom+ogjn2YXTL1HgoXdn0ws+qyyYVxHYdrNbi\n" +
                    "A6xsXtvA4FIgw+amfiTb82NpQsjKZfm2h3CcvLpCxPiYD5z+0c1XkWkXslXMBfCJ\n" +
                    "3HMM1NostSYIkzGEglbPH3B3iRWeng9xe20QsnjGSTc+Cet0tlCZZvGrr0wemxjy\n" +
                    "Wi136wi7iKEMjF75E4L4AnGT7/Lpl9pHOlJ0i8nv6dhXTZNH4otlGTBscxxZi5FB\n" +
                    "mWbEnUYlS+E0QJjPEBN5T0ucScY16XS14bPdEPQEiQKBgQDxzCaCuSjuhCobG6oP\n" +
                    "FFvU74iSj7QYOsxYlVGLSij0W8aVeLcVHF/vr9sI3/9gDy8tsDkBDDuWStT6jixZ\n" +
                    "bAmc0uHN5GJ4wReojxNTemkj0eqQ1Q5L+usfspw+vTYODVfVsnrYU92loFEn93Le\n" +
                    "Ffl0mi5p7UWq39hrAE98Pe7SJwKBgQDNfV8NrOItSe8I3pwvgB5QUHZbjSk2GfXS\n" +
                    "lqbxBMY90dxrTnkdRfzD4TxwuN8PSW2kSznmcit1T7btGWsTsPvDDgzHGibZu6G5\n" +
                    "GsZOXpj8fGaGItd9MStMdg9OFBnLPgtbm5tbPH31nPS6sXdl+j2kChlQeQmrx19u\n" +
                    "rZxDgI8HrQKBgQCv78HdwGieFKCmlNyKmF+xcpFHQzThpHbnxc5NsapXEyhNvkZJ\n" +
                    "IBpWRvjzXjltZd8IOX9g2cvJsa2Cmkx+zHO6Hl+a9qEICEf0qBaB2UIDhExPEheT\n" +
                    "BYJr0ASMShS46NCOd42XNn7CcwJaOFzmZ8rZIw6+mJzmlnXcdZ9gYZgSZQKBgETo\n" +
                    "iuySEhKv3VmzFNsU8pVqNhaDYtOCpx2kaX0fZb8rVegiG5lGc/nX2SXPyPVeYUcb\n" +
                    "9uGhXZNsVOJziKXEzthdKMnHqkmPky74nJGBRXo92T+YBX009NkiKgW71d6DAtoI\n" +
                    "d3OD+JVZufO1OV3YKb2NqWmD/Us+g3EhBOrZ/JzNAoGAAOnUfitSvZHwYxbBl2Zl\n" +
                    "1oueDdUGgI0gVN7OA80GuN1J30mbh3zISSJRiXUz9zptTOnBknP08yHVNkQuKse+\n" +
                    "fnlYaow6iCrIZyDb8jIyVqaiGx2HICvajDB59n1zMuOXbfRCvxhfbz76g8oWuj0i\n" +
                    "7Bndhd60D/bNBsq8nEEfbN4=\n" +
                    "-----END PRIVATE KEY-----\n" +
                    "</key>\n" +
                    "<tls-crypt>\n" +
                    "-----BEGIN OpenVPN Static key V1-----\n" +
                    "df167a48c5db52ec2c5a4dd05c62743c\n" +
                    "3231fc80a09b5bb646766f5ff2c060a8\n" +
                    "3c3f92e1f445b2b7dbe639b7cb0f3509\n" +
                    "316d20379a9255a7c81900ecc748497d\n" +
                    "3560f33275e18262b6198c0f0530bd3a\n" +
                    "9ee02afe0502042e65e4da4d2669dd41\n" +
                    "10ec4e622a7d758b6492d6fd776cb0b7\n" +
                    "749fc38239f5e736d1b8411f6eb0ae63\n" +
                    "1bab148e11eb9c963cdcc6620f12d16e\n" +
                    "ab8ab8dd37976c3ae7d503e21dd0f5af\n" +
                    "23bb104d10e46eb6fa053cd1af73efa4\n" +
                    "b68f529bfbc634a531659e86744d065b\n" +
                    "0c547c8dc9265f92df57be82c4364bcd\n" +
                    "7fb02a14ea626f3d4a278bb29f028d87\n" +
                    "306a63fb3ff38137c683e02f50e982c6\n" +
                    "0a04e75ef67c3663c8ef18bc8bd0b13e\n" +
                    "-----END OpenVPN Static key V1-----\n" +
                    "</tls-crypt>\n"
        ),
        ServerModel(
            3,
            "Armenia",
            "172.16.0.1",
            R.drawable.fl_argentina,
            "client\n" +
                    "dev tun\n" +
                    "proto tcp\n" +
                    "remote 38.180.61.53 943\n" +
                    "resolv-retry infinite\n" +
                    "nobind\n" +
                    "persist-key\n" +
                    "persist-tun\n" +
                    "remote-cert-tls server\n" +
                    "auth SHA512\n" +
                    "ignore-unknown-option block-outside-dns\n" +
                    "verb 3\n" +
                    "<ca>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDSzCCAjOgAwIBAgIUT6IyRhA5k4KJX023J0kxqvQ/UHgwDQYJKoZIhvcNAQEL\n" +
                    "BQAwFjEUMBIGA1UEAwwLRWFzeS1SU0EgQ0EwHhcNMjQwMjAxMTQyNTMxWhcNMzQw\n" +
                    "MTI5MTQyNTMxWjAWMRQwEgYDVQQDDAtFYXN5LVJTQSBDQTCCASIwDQYJKoZIhvcN\n" +
                    "AQEBBQADggEPADCCAQoCggEBAPXSwGP/+aU+Y1N0ID/7wUaK9erZujZpZzL33/Q1\n" +
                    "bbdsR0My4sr1OzvzsCp/xamQkNEQRtRJR1gQ0V/Kt0xPU01TRystmbzLcTBknZDI\n" +
                    "xWRi7zrr9pYiMgThF0M8ZWxsIcg3gxKQH+cG+9elrOtGBDBMSzL25TiaWBMZVnTi\n" +
                    "71Qndps58nzrw2Rj83jqyJUp1KLhlNjCRrmtbmeX2vphpXdLJuFfjTB3v5+O+kcV\n" +
                    "GAppzrIdiRqblFt0dfgi5ez0Ou7OAv6yyZkgNDwpd2zWvRkvX5XyHvfR6mUbm6C1\n" +
                    "GZOUUi+yWdvhPnMa++jIJOPWbSZzOOXRpm+RVpCL1mvHTykCAwEAAaOBkDCBjTAM\n" +
                    "BgNVHRMEBTADAQH/MB0GA1UdDgQWBBTa0Bbct/9Kt3LuUZlbxnjfbh5/xzBRBgNV\n" +
                    "HSMESjBIgBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFz\n" +
                    "eS1SU0EgQ0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MAsGA1UdDwQEAwIBBjANBgkq\n" +
                    "hkiG9w0BAQsFAAOCAQEAEcXuSouJCqI4Fe4zuonk5n91zSMzQJSKAOtxkCW23mtE\n" +
                    "9OoWgKuyUjFTPSvlZpZ55/P8/KCKdQyyRmE7Hixvz2DKosbusvFiZIBrKiwAoBtR\n" +
                    "++CYhQnWIE8+p1TRTlWsgLFo/dfU82OEIgRPqnhNwR2T3xpnKvpgfazgVY12qQPf\n" +
                    "hwzrpnT8W90sv6PiO/CsMeaG95n899KyNqjjUJVat0YSehbA0nqdb7VWc157IpOn\n" +
                    "BVkRvOlIwkL7Xcjr0KiIlTkaIMDMw7lDBJG6eR0SNUGLxiGdeIg9FxWjRe0nBXwO\n" +
                    "d0gDWKiYurcJ1FW3l3LB8RFoT9Z/38cu4zIbeET/DQ==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</ca>\n" +
                    "<cert>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDWjCCAkKgAwIBAgIQUFOAPLGi/ZlB+5TCJVYJAzANBgkqhkiG9w0BAQsFADAW\n" +
                    "MRQwEgYDVQQDDAtFYXN5LVJTQSBDQTAeFw0yNDAyMDExNDI1MzFaFw0zNDAxMjkx\n" +
                    "NDI1MzFaMBcxFTATBgNVBAMMDHVuaXRlZHN0YXRlczCCASIwDQYJKoZIhvcNAQEB\n" +
                    "BQADggEPADCCAQoCggEBAMIW5U0pDXI2b2hRiAvvIUdVo2W0+jRs05XZpVOPBaNu\n" +
                    "4+p1oS7DEnfft7IRd5C6aVUyiPi4/ELgceV6N33Gw+0gboKAAQ9152gqM+ul/YdW\n" +
                    "ZZwMiM0/NPjZX28wMSDRvizfjKHSaNxu5YoWMmbOLqNFX6l9O6I7P9WPd5fP32e3\n" +
                    "uQ6mv9XOa0oW2E9tRPOgkl4rfoSPcceVN9jegMnPQ/HniYBu67aQcaRySXSXJGD2\n" +
                    "qs2ymovhe1fGmB+9qukMbyeBc1KcZjxvCSU2XqizhweW+9XleJZnuY0/Df+aHHPH\n" +
                    "pSWNmE6D4TPa4fO+y01jMkBrsGyrHGaDWqviV0XsFVsCAwEAAaOBojCBnzAJBgNV\n" +
                    "HRMEAjAAMB0GA1UdDgQWBBShaCd+G3bz4xSAIuGMJoCH4k3jWzBRBgNVHSMESjBI\n" +
                    "gBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFzeS1SU0Eg\n" +
                    "Q0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MBMGA1UdJQQMMAoGCCsGAQUFBwMCMAsG\n" +
                    "A1UdDwQEAwIHgDANBgkqhkiG9w0BAQsFAAOCAQEAk1JY5m44+mSM+Eq3bNEYZ1Hz\n" +
                    "kFz+oN3NesemC8HSCbDIMk4N4nxKczgmlSDFxhCdMChBlmSoidUYwis889Jp90gp\n" +
                    "IS/jZbFAR2k+1nj8lZgSWr5bLL0onIu3XwSevhlFaZaT5Slcl952PWvSr9GnYBD2\n" +
                    "MSAaOZfWOYZGlTJl2cZpqLc+OPo+GDsQd3ERfCaR4fmYEgk7Y7rKzBUt+BD4QAhA\n" +
                    "4C4VHnBvfPk9/SB+B4jslGql5lbhdF2drLSQS06z623+E804bX4PZg7IYe6Fz1fW\n" +
                    "5Oc2i87sagXb0eYRB28fpUMRcGi+GtBC2kc8/3pPmvWeY5QO5B1yj/X//fxDRg==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</cert>\n" +
                    "<key>\n" +
                    "-----BEGIN PRIVATE KEY-----\n" +
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDCFuVNKQ1yNm9o\n" +
                    "UYgL7yFHVaNltPo0bNOV2aVTjwWjbuPqdaEuwxJ337eyEXeQumlVMoj4uPxC4HHl\n" +
                    "ejd9xsPtIG6CgAEPdedoKjPrpf2HVmWcDIjNPzT42V9vMDEg0b4s34yh0mjcbuWK\n" +
                    "FjJmzi6jRV+pfTuiOz/Vj3eXz99nt7kOpr/VzmtKFthPbUTzoJJeK36Ej3HHlTfY\n" +
                    "3oDJz0Px54mAbuu2kHGkckl0lyRg9qrNspqL4XtXxpgfvarpDG8ngXNSnGY8bwkl\n" +
                    "Nl6os4cHlvvV5XiWZ7mNPw3/mhxzx6UljZhOg+Ez2uHzvstNYzJAa7Bsqxxmg1qr\n" +
                    "4ldF7BVbAgMBAAECggEAFJFakVe1XhIYskRZl3Iq46VWoHOSRDX4IhwjYfx5C323\n" +
                    "12PJxevULDHgBJXHRuYKPYYSb9Eiom+ogjn2YXTL1HgoXdn0ws+qyyYVxHYdrNbi\n" +
                    "A6xsXtvA4FIgw+amfiTb82NpQsjKZfm2h3CcvLpCxPiYD5z+0c1XkWkXslXMBfCJ\n" +
                    "3HMM1NostSYIkzGEglbPH3B3iRWeng9xe20QsnjGSTc+Cet0tlCZZvGrr0wemxjy\n" +
                    "Wi136wi7iKEMjF75E4L4AnGT7/Lpl9pHOlJ0i8nv6dhXTZNH4otlGTBscxxZi5FB\n" +
                    "mWbEnUYlS+E0QJjPEBN5T0ucScY16XS14bPdEPQEiQKBgQDxzCaCuSjuhCobG6oP\n" +
                    "FFvU74iSj7QYOsxYlVGLSij0W8aVeLcVHF/vr9sI3/9gDy8tsDkBDDuWStT6jixZ\n" +
                    "bAmc0uHN5GJ4wReojxNTemkj0eqQ1Q5L+usfspw+vTYODVfVsnrYU92loFEn93Le\n" +
                    "Ffl0mi5p7UWq39hrAE98Pe7SJwKBgQDNfV8NrOItSe8I3pwvgB5QUHZbjSk2GfXS\n" +
                    "lqbxBMY90dxrTnkdRfzD4TxwuN8PSW2kSznmcit1T7btGWsTsPvDDgzHGibZu6G5\n" +
                    "GsZOXpj8fGaGItd9MStMdg9OFBnLPgtbm5tbPH31nPS6sXdl+j2kChlQeQmrx19u\n" +
                    "rZxDgI8HrQKBgQCv78HdwGieFKCmlNyKmF+xcpFHQzThpHbnxc5NsapXEyhNvkZJ\n" +
                    "IBpWRvjzXjltZd8IOX9g2cvJsa2Cmkx+zHO6Hl+a9qEICEf0qBaB2UIDhExPEheT\n" +
                    "BYJr0ASMShS46NCOd42XNn7CcwJaOFzmZ8rZIw6+mJzmlnXcdZ9gYZgSZQKBgETo\n" +
                    "iuySEhKv3VmzFNsU8pVqNhaDYtOCpx2kaX0fZb8rVegiG5lGc/nX2SXPyPVeYUcb\n" +
                    "9uGhXZNsVOJziKXEzthdKMnHqkmPky74nJGBRXo92T+YBX009NkiKgW71d6DAtoI\n" +
                    "d3OD+JVZufO1OV3YKb2NqWmD/Us+g3EhBOrZ/JzNAoGAAOnUfitSvZHwYxbBl2Zl\n" +
                    "1oueDdUGgI0gVN7OA80GuN1J30mbh3zISSJRiXUz9zptTOnBknP08yHVNkQuKse+\n" +
                    "fnlYaow6iCrIZyDb8jIyVqaiGx2HICvajDB59n1zMuOXbfRCvxhfbz76g8oWuj0i\n" +
                    "7Bndhd60D/bNBsq8nEEfbN4=\n" +
                    "-----END PRIVATE KEY-----\n" +
                    "</key>\n" +
                    "<tls-crypt>\n" +
                    "-----BEGIN OpenVPN Static key V1-----\n" +
                    "df167a48c5db52ec2c5a4dd05c62743c\n" +
                    "3231fc80a09b5bb646766f5ff2c060a8\n" +
                    "3c3f92e1f445b2b7dbe639b7cb0f3509\n" +
                    "316d20379a9255a7c81900ecc748497d\n" +
                    "3560f33275e18262b6198c0f0530bd3a\n" +
                    "9ee02afe0502042e65e4da4d2669dd41\n" +
                    "10ec4e622a7d758b6492d6fd776cb0b7\n" +
                    "749fc38239f5e736d1b8411f6eb0ae63\n" +
                    "1bab148e11eb9c963cdcc6620f12d16e\n" +
                    "ab8ab8dd37976c3ae7d503e21dd0f5af\n" +
                    "23bb104d10e46eb6fa053cd1af73efa4\n" +
                    "b68f529bfbc634a531659e86744d065b\n" +
                    "0c547c8dc9265f92df57be82c4364bcd\n" +
                    "7fb02a14ea626f3d4a278bb29f028d87\n" +
                    "306a63fb3ff38137c683e02f50e982c6\n" +
                    "0a04e75ef67c3663c8ef18bc8bd0b13e\n" +
                    "-----END OpenVPN Static key V1-----\n" +
                    "</tls-crypt>\n"
        ),
        ServerModel(
            4,
            "United Kingdom",
            "192.0.2.2",
            R.drawable.fl_uk,
            "client\n" +
                    "dev tun\n" +
                    "proto tcp\n" +
                    "remote 38.180.61.53 943\n" +
                    "resolv-retry infinite\n" +
                    "nobind\n" +
                    "persist-key\n" +
                    "persist-tun\n" +
                    "remote-cert-tls server\n" +
                    "auth SHA512\n" +
                    "ignore-unknown-option block-outside-dns\n" +
                    "verb 3\n" +
                    "<ca>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDSzCCAjOgAwIBAgIUT6IyRhA5k4KJX023J0kxqvQ/UHgwDQYJKoZIhvcNAQEL\n" +
                    "BQAwFjEUMBIGA1UEAwwLRWFzeS1SU0EgQ0EwHhcNMjQwMjAxMTQyNTMxWhcNMzQw\n" +
                    "MTI5MTQyNTMxWjAWMRQwEgYDVQQDDAtFYXN5LVJTQSBDQTCCASIwDQYJKoZIhvcN\n" +
                    "AQEBBQADggEPADCCAQoCggEBAPXSwGP/+aU+Y1N0ID/7wUaK9erZujZpZzL33/Q1\n" +
                    "bbdsR0My4sr1OzvzsCp/xamQkNEQRtRJR1gQ0V/Kt0xPU01TRystmbzLcTBknZDI\n" +
                    "xWRi7zrr9pYiMgThF0M8ZWxsIcg3gxKQH+cG+9elrOtGBDBMSzL25TiaWBMZVnTi\n" +
                    "71Qndps58nzrw2Rj83jqyJUp1KLhlNjCRrmtbmeX2vphpXdLJuFfjTB3v5+O+kcV\n" +
                    "GAppzrIdiRqblFt0dfgi5ez0Ou7OAv6yyZkgNDwpd2zWvRkvX5XyHvfR6mUbm6C1\n" +
                    "GZOUUi+yWdvhPnMa++jIJOPWbSZzOOXRpm+RVpCL1mvHTykCAwEAAaOBkDCBjTAM\n" +
                    "BgNVHRMEBTADAQH/MB0GA1UdDgQWBBTa0Bbct/9Kt3LuUZlbxnjfbh5/xzBRBgNV\n" +
                    "HSMESjBIgBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFz\n" +
                    "eS1SU0EgQ0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MAsGA1UdDwQEAwIBBjANBgkq\n" +
                    "hkiG9w0BAQsFAAOCAQEAEcXuSouJCqI4Fe4zuonk5n91zSMzQJSKAOtxkCW23mtE\n" +
                    "9OoWgKuyUjFTPSvlZpZ55/P8/KCKdQyyRmE7Hixvz2DKosbusvFiZIBrKiwAoBtR\n" +
                    "++CYhQnWIE8+p1TRTlWsgLFo/dfU82OEIgRPqnhNwR2T3xpnKvpgfazgVY12qQPf\n" +
                    "hwzrpnT8W90sv6PiO/CsMeaG95n899KyNqjjUJVat0YSehbA0nqdb7VWc157IpOn\n" +
                    "BVkRvOlIwkL7Xcjr0KiIlTkaIMDMw7lDBJG6eR0SNUGLxiGdeIg9FxWjRe0nBXwO\n" +
                    "d0gDWKiYurcJ1FW3l3LB8RFoT9Z/38cu4zIbeET/DQ==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</ca>\n" +
                    "<cert>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDWjCCAkKgAwIBAgIQUFOAPLGi/ZlB+5TCJVYJAzANBgkqhkiG9w0BAQsFADAW\n" +
                    "MRQwEgYDVQQDDAtFYXN5LVJTQSBDQTAeFw0yNDAyMDExNDI1MzFaFw0zNDAxMjkx\n" +
                    "NDI1MzFaMBcxFTATBgNVBAMMDHVuaXRlZHN0YXRlczCCASIwDQYJKoZIhvcNAQEB\n" +
                    "BQADggEPADCCAQoCggEBAMIW5U0pDXI2b2hRiAvvIUdVo2W0+jRs05XZpVOPBaNu\n" +
                    "4+p1oS7DEnfft7IRd5C6aVUyiPi4/ELgceV6N33Gw+0gboKAAQ9152gqM+ul/YdW\n" +
                    "ZZwMiM0/NPjZX28wMSDRvizfjKHSaNxu5YoWMmbOLqNFX6l9O6I7P9WPd5fP32e3\n" +
                    "uQ6mv9XOa0oW2E9tRPOgkl4rfoSPcceVN9jegMnPQ/HniYBu67aQcaRySXSXJGD2\n" +
                    "qs2ymovhe1fGmB+9qukMbyeBc1KcZjxvCSU2XqizhweW+9XleJZnuY0/Df+aHHPH\n" +
                    "pSWNmE6D4TPa4fO+y01jMkBrsGyrHGaDWqviV0XsFVsCAwEAAaOBojCBnzAJBgNV\n" +
                    "HRMEAjAAMB0GA1UdDgQWBBShaCd+G3bz4xSAIuGMJoCH4k3jWzBRBgNVHSMESjBI\n" +
                    "gBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFzeS1SU0Eg\n" +
                    "Q0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MBMGA1UdJQQMMAoGCCsGAQUFBwMCMAsG\n" +
                    "A1UdDwQEAwIHgDANBgkqhkiG9w0BAQsFAAOCAQEAk1JY5m44+mSM+Eq3bNEYZ1Hz\n" +
                    "kFz+oN3NesemC8HSCbDIMk4N4nxKczgmlSDFxhCdMChBlmSoidUYwis889Jp90gp\n" +
                    "IS/jZbFAR2k+1nj8lZgSWr5bLL0onIu3XwSevhlFaZaT5Slcl952PWvSr9GnYBD2\n" +
                    "MSAaOZfWOYZGlTJl2cZpqLc+OPo+GDsQd3ERfCaR4fmYEgk7Y7rKzBUt+BD4QAhA\n" +
                    "4C4VHnBvfPk9/SB+B4jslGql5lbhdF2drLSQS06z623+E804bX4PZg7IYe6Fz1fW\n" +
                    "5Oc2i87sagXb0eYRB28fpUMRcGi+GtBC2kc8/3pPmvWeY5QO5B1yj/X//fxDRg==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</cert>\n" +
                    "<key>\n" +
                    "-----BEGIN PRIVATE KEY-----\n" +
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDCFuVNKQ1yNm9o\n" +
                    "UYgL7yFHVaNltPo0bNOV2aVTjwWjbuPqdaEuwxJ337eyEXeQumlVMoj4uPxC4HHl\n" +
                    "ejd9xsPtIG6CgAEPdedoKjPrpf2HVmWcDIjNPzT42V9vMDEg0b4s34yh0mjcbuWK\n" +
                    "FjJmzi6jRV+pfTuiOz/Vj3eXz99nt7kOpr/VzmtKFthPbUTzoJJeK36Ej3HHlTfY\n" +
                    "3oDJz0Px54mAbuu2kHGkckl0lyRg9qrNspqL4XtXxpgfvarpDG8ngXNSnGY8bwkl\n" +
                    "Nl6os4cHlvvV5XiWZ7mNPw3/mhxzx6UljZhOg+Ez2uHzvstNYzJAa7Bsqxxmg1qr\n" +
                    "4ldF7BVbAgMBAAECggEAFJFakVe1XhIYskRZl3Iq46VWoHOSRDX4IhwjYfx5C323\n" +
                    "12PJxevULDHgBJXHRuYKPYYSb9Eiom+ogjn2YXTL1HgoXdn0ws+qyyYVxHYdrNbi\n" +
                    "A6xsXtvA4FIgw+amfiTb82NpQsjKZfm2h3CcvLpCxPiYD5z+0c1XkWkXslXMBfCJ\n" +
                    "3HMM1NostSYIkzGEglbPH3B3iRWeng9xe20QsnjGSTc+Cet0tlCZZvGrr0wemxjy\n" +
                    "Wi136wi7iKEMjF75E4L4AnGT7/Lpl9pHOlJ0i8nv6dhXTZNH4otlGTBscxxZi5FB\n" +
                    "mWbEnUYlS+E0QJjPEBN5T0ucScY16XS14bPdEPQEiQKBgQDxzCaCuSjuhCobG6oP\n" +
                    "FFvU74iSj7QYOsxYlVGLSij0W8aVeLcVHF/vr9sI3/9gDy8tsDkBDDuWStT6jixZ\n" +
                    "bAmc0uHN5GJ4wReojxNTemkj0eqQ1Q5L+usfspw+vTYODVfVsnrYU92loFEn93Le\n" +
                    "Ffl0mi5p7UWq39hrAE98Pe7SJwKBgQDNfV8NrOItSe8I3pwvgB5QUHZbjSk2GfXS\n" +
                    "lqbxBMY90dxrTnkdRfzD4TxwuN8PSW2kSznmcit1T7btGWsTsPvDDgzHGibZu6G5\n" +
                    "GsZOXpj8fGaGItd9MStMdg9OFBnLPgtbm5tbPH31nPS6sXdl+j2kChlQeQmrx19u\n" +
                    "rZxDgI8HrQKBgQCv78HdwGieFKCmlNyKmF+xcpFHQzThpHbnxc5NsapXEyhNvkZJ\n" +
                    "IBpWRvjzXjltZd8IOX9g2cvJsa2Cmkx+zHO6Hl+a9qEICEf0qBaB2UIDhExPEheT\n" +
                    "BYJr0ASMShS46NCOd42XNn7CcwJaOFzmZ8rZIw6+mJzmlnXcdZ9gYZgSZQKBgETo\n" +
                    "iuySEhKv3VmzFNsU8pVqNhaDYtOCpx2kaX0fZb8rVegiG5lGc/nX2SXPyPVeYUcb\n" +
                    "9uGhXZNsVOJziKXEzthdKMnHqkmPky74nJGBRXo92T+YBX009NkiKgW71d6DAtoI\n" +
                    "d3OD+JVZufO1OV3YKb2NqWmD/Us+g3EhBOrZ/JzNAoGAAOnUfitSvZHwYxbBl2Zl\n" +
                    "1oueDdUGgI0gVN7OA80GuN1J30mbh3zISSJRiXUz9zptTOnBknP08yHVNkQuKse+\n" +
                    "fnlYaow6iCrIZyDb8jIyVqaiGx2HICvajDB59n1zMuOXbfRCvxhfbz76g8oWuj0i\n" +
                    "7Bndhd60D/bNBsq8nEEfbN4=\n" +
                    "-----END PRIVATE KEY-----\n" +
                    "</key>\n" +
                    "<tls-crypt>\n" +
                    "-----BEGIN OpenVPN Static key V1-----\n" +
                    "df167a48c5db52ec2c5a4dd05c62743c\n" +
                    "3231fc80a09b5bb646766f5ff2c060a8\n" +
                    "3c3f92e1f445b2b7dbe639b7cb0f3509\n" +
                    "316d20379a9255a7c81900ecc748497d\n" +
                    "3560f33275e18262b6198c0f0530bd3a\n" +
                    "9ee02afe0502042e65e4da4d2669dd41\n" +
                    "10ec4e622a7d758b6492d6fd776cb0b7\n" +
                    "749fc38239f5e736d1b8411f6eb0ae63\n" +
                    "1bab148e11eb9c963cdcc6620f12d16e\n" +
                    "ab8ab8dd37976c3ae7d503e21dd0f5af\n" +
                    "23bb104d10e46eb6fa053cd1af73efa4\n" +
                    "b68f529bfbc634a531659e86744d065b\n" +
                    "0c547c8dc9265f92df57be82c4364bcd\n" +
                    "7fb02a14ea626f3d4a278bb29f028d87\n" +
                    "306a63fb3ff38137c683e02f50e982c6\n" +
                    "0a04e75ef67c3663c8ef18bc8bd0b13e\n" +
                    "-----END OpenVPN Static key V1-----\n" +
                    "</tls-crypt>\n"
        ),
        ServerModel(
            5,
            "Gabon",
            "185.53.178.9",
            R.drawable.fl_gabon,
            "client\n" +
                    "dev tun\n" +
                    "proto tcp\n" +
                    "remote 38.180.61.53 943\n" +
                    "resolv-retry infinite\n" +
                    "nobind\n" +
                    "persist-key\n" +
                    "persist-tun\n" +
                    "remote-cert-tls server\n" +
                    "auth SHA512\n" +
                    "ignore-unknown-option block-outside-dns\n" +
                    "verb 3\n" +
                    "<ca>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDSzCCAjOgAwIBAgIUT6IyRhA5k4KJX023J0kxqvQ/UHgwDQYJKoZIhvcNAQEL\n" +
                    "BQAwFjEUMBIGA1UEAwwLRWFzeS1SU0EgQ0EwHhcNMjQwMjAxMTQyNTMxWhcNMzQw\n" +
                    "MTI5MTQyNTMxWjAWMRQwEgYDVQQDDAtFYXN5LVJTQSBDQTCCASIwDQYJKoZIhvcN\n" +
                    "AQEBBQADggEPADCCAQoCggEBAPXSwGP/+aU+Y1N0ID/7wUaK9erZujZpZzL33/Q1\n" +
                    "bbdsR0My4sr1OzvzsCp/xamQkNEQRtRJR1gQ0V/Kt0xPU01TRystmbzLcTBknZDI\n" +
                    "xWRi7zrr9pYiMgThF0M8ZWxsIcg3gxKQH+cG+9elrOtGBDBMSzL25TiaWBMZVnTi\n" +
                    "71Qndps58nzrw2Rj83jqyJUp1KLhlNjCRrmtbmeX2vphpXdLJuFfjTB3v5+O+kcV\n" +
                    "GAppzrIdiRqblFt0dfgi5ez0Ou7OAv6yyZkgNDwpd2zWvRkvX5XyHvfR6mUbm6C1\n" +
                    "GZOUUi+yWdvhPnMa++jIJOPWbSZzOOXRpm+RVpCL1mvHTykCAwEAAaOBkDCBjTAM\n" +
                    "BgNVHRMEBTADAQH/MB0GA1UdDgQWBBTa0Bbct/9Kt3LuUZlbxnjfbh5/xzBRBgNV\n" +
                    "HSMESjBIgBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFz\n" +
                    "eS1SU0EgQ0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MAsGA1UdDwQEAwIBBjANBgkq\n" +
                    "hkiG9w0BAQsFAAOCAQEAEcXuSouJCqI4Fe4zuonk5n91zSMzQJSKAOtxkCW23mtE\n" +
                    "9OoWgKuyUjFTPSvlZpZ55/P8/KCKdQyyRmE7Hixvz2DKosbusvFiZIBrKiwAoBtR\n" +
                    "++CYhQnWIE8+p1TRTlWsgLFo/dfU82OEIgRPqnhNwR2T3xpnKvpgfazgVY12qQPf\n" +
                    "hwzrpnT8W90sv6PiO/CsMeaG95n899KyNqjjUJVat0YSehbA0nqdb7VWc157IpOn\n" +
                    "BVkRvOlIwkL7Xcjr0KiIlTkaIMDMw7lDBJG6eR0SNUGLxiGdeIg9FxWjRe0nBXwO\n" +
                    "d0gDWKiYurcJ1FW3l3LB8RFoT9Z/38cu4zIbeET/DQ==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</ca>\n" +
                    "<cert>\n" +
                    "-----BEGIN CERTIFICATE-----\n" +
                    "MIIDWjCCAkKgAwIBAgIQUFOAPLGi/ZlB+5TCJVYJAzANBgkqhkiG9w0BAQsFADAW\n" +
                    "MRQwEgYDVQQDDAtFYXN5LVJTQSBDQTAeFw0yNDAyMDExNDI1MzFaFw0zNDAxMjkx\n" +
                    "NDI1MzFaMBcxFTATBgNVBAMMDHVuaXRlZHN0YXRlczCCASIwDQYJKoZIhvcNAQEB\n" +
                    "BQADggEPADCCAQoCggEBAMIW5U0pDXI2b2hRiAvvIUdVo2W0+jRs05XZpVOPBaNu\n" +
                    "4+p1oS7DEnfft7IRd5C6aVUyiPi4/ELgceV6N33Gw+0gboKAAQ9152gqM+ul/YdW\n" +
                    "ZZwMiM0/NPjZX28wMSDRvizfjKHSaNxu5YoWMmbOLqNFX6l9O6I7P9WPd5fP32e3\n" +
                    "uQ6mv9XOa0oW2E9tRPOgkl4rfoSPcceVN9jegMnPQ/HniYBu67aQcaRySXSXJGD2\n" +
                    "qs2ymovhe1fGmB+9qukMbyeBc1KcZjxvCSU2XqizhweW+9XleJZnuY0/Df+aHHPH\n" +
                    "pSWNmE6D4TPa4fO+y01jMkBrsGyrHGaDWqviV0XsFVsCAwEAAaOBojCBnzAJBgNV\n" +
                    "HRMEAjAAMB0GA1UdDgQWBBShaCd+G3bz4xSAIuGMJoCH4k3jWzBRBgNVHSMESjBI\n" +
                    "gBTa0Bbct/9Kt3LuUZlbxnjfbh5/x6EapBgwFjEUMBIGA1UEAwwLRWFzeS1SU0Eg\n" +
                    "Q0GCFE+iMkYQOZOCiV9NtydJMar0P1B4MBMGA1UdJQQMMAoGCCsGAQUFBwMCMAsG\n" +
                    "A1UdDwQEAwIHgDANBgkqhkiG9w0BAQsFAAOCAQEAk1JY5m44+mSM+Eq3bNEYZ1Hz\n" +
                    "kFz+oN3NesemC8HSCbDIMk4N4nxKczgmlSDFxhCdMChBlmSoidUYwis889Jp90gp\n" +
                    "IS/jZbFAR2k+1nj8lZgSWr5bLL0onIu3XwSevhlFaZaT5Slcl952PWvSr9GnYBD2\n" +
                    "MSAaOZfWOYZGlTJl2cZpqLc+OPo+GDsQd3ERfCaR4fmYEgk7Y7rKzBUt+BD4QAhA\n" +
                    "4C4VHnBvfPk9/SB+B4jslGql5lbhdF2drLSQS06z623+E804bX4PZg7IYe6Fz1fW\n" +
                    "5Oc2i87sagXb0eYRB28fpUMRcGi+GtBC2kc8/3pPmvWeY5QO5B1yj/X//fxDRg==\n" +
                    "-----END CERTIFICATE-----\n" +
                    "</cert>\n" +
                    "<key>\n" +
                    "-----BEGIN PRIVATE KEY-----\n" +
                    "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDCFuVNKQ1yNm9o\n" +
                    "UYgL7yFHVaNltPo0bNOV2aVTjwWjbuPqdaEuwxJ337eyEXeQumlVMoj4uPxC4HHl\n" +
                    "ejd9xsPtIG6CgAEPdedoKjPrpf2HVmWcDIjNPzT42V9vMDEg0b4s34yh0mjcbuWK\n" +
                    "FjJmzi6jRV+pfTuiOz/Vj3eXz99nt7kOpr/VzmtKFthPbUTzoJJeK36Ej3HHlTfY\n" +
                    "3oDJz0Px54mAbuu2kHGkckl0lyRg9qrNspqL4XtXxpgfvarpDG8ngXNSnGY8bwkl\n" +
                    "Nl6os4cHlvvV5XiWZ7mNPw3/mhxzx6UljZhOg+Ez2uHzvstNYzJAa7Bsqxxmg1qr\n" +
                    "4ldF7BVbAgMBAAECggEAFJFakVe1XhIYskRZl3Iq46VWoHOSRDX4IhwjYfx5C323\n" +
                    "12PJxevULDHgBJXHRuYKPYYSb9Eiom+ogjn2YXTL1HgoXdn0ws+qyyYVxHYdrNbi\n" +
                    "A6xsXtvA4FIgw+amfiTb82NpQsjKZfm2h3CcvLpCxPiYD5z+0c1XkWkXslXMBfCJ\n" +
                    "3HMM1NostSYIkzGEglbPH3B3iRWeng9xe20QsnjGSTc+Cet0tlCZZvGrr0wemxjy\n" +
                    "Wi136wi7iKEMjF75E4L4AnGT7/Lpl9pHOlJ0i8nv6dhXTZNH4otlGTBscxxZi5FB\n" +
                    "mWbEnUYlS+E0QJjPEBN5T0ucScY16XS14bPdEPQEiQKBgQDxzCaCuSjuhCobG6oP\n" +
                    "FFvU74iSj7QYOsxYlVGLSij0W8aVeLcVHF/vr9sI3/9gDy8tsDkBDDuWStT6jixZ\n" +
                    "bAmc0uHN5GJ4wReojxNTemkj0eqQ1Q5L+usfspw+vTYODVfVsnrYU92loFEn93Le\n" +
                    "Ffl0mi5p7UWq39hrAE98Pe7SJwKBgQDNfV8NrOItSe8I3pwvgB5QUHZbjSk2GfXS\n" +
                    "lqbxBMY90dxrTnkdRfzD4TxwuN8PSW2kSznmcit1T7btGWsTsPvDDgzHGibZu6G5\n" +
                    "GsZOXpj8fGaGItd9MStMdg9OFBnLPgtbm5tbPH31nPS6sXdl+j2kChlQeQmrx19u\n" +
                    "rZxDgI8HrQKBgQCv78HdwGieFKCmlNyKmF+xcpFHQzThpHbnxc5NsapXEyhNvkZJ\n" +
                    "IBpWRvjzXjltZd8IOX9g2cvJsa2Cmkx+zHO6Hl+a9qEICEf0qBaB2UIDhExPEheT\n" +
                    "BYJr0ASMShS46NCOd42XNn7CcwJaOFzmZ8rZIw6+mJzmlnXcdZ9gYZgSZQKBgETo\n" +
                    "iuySEhKv3VmzFNsU8pVqNhaDYtOCpx2kaX0fZb8rVegiG5lGc/nX2SXPyPVeYUcb\n" +
                    "9uGhXZNsVOJziKXEzthdKMnHqkmPky74nJGBRXo92T+YBX009NkiKgW71d6DAtoI\n" +
                    "d3OD+JVZufO1OV3YKb2NqWmD/Us+g3EhBOrZ/JzNAoGAAOnUfitSvZHwYxbBl2Zl\n" +
                    "1oueDdUGgI0gVN7OA80GuN1J30mbh3zISSJRiXUz9zptTOnBknP08yHVNkQuKse+\n" +
                    "fnlYaow6iCrIZyDb8jIyVqaiGx2HICvajDB59n1zMuOXbfRCvxhfbz76g8oWuj0i\n" +
                    "7Bndhd60D/bNBsq8nEEfbN4=\n" +
                    "-----END PRIVATE KEY-----\n" +
                    "</key>\n" +
                    "<tls-crypt>\n" +
                    "-----BEGIN OpenVPN Static key V1-----\n" +
                    "df167a48c5db52ec2c5a4dd05c62743c\n" +
                    "3231fc80a09b5bb646766f5ff2c060a8\n" +
                    "3c3f92e1f445b2b7dbe639b7cb0f3509\n" +
                    "316d20379a9255a7c81900ecc748497d\n" +
                    "3560f33275e18262b6198c0f0530bd3a\n" +
                    "9ee02afe0502042e65e4da4d2669dd41\n" +
                    "10ec4e622a7d758b6492d6fd776cb0b7\n" +
                    "749fc38239f5e736d1b8411f6eb0ae63\n" +
                    "1bab148e11eb9c963cdcc6620f12d16e\n" +
                    "ab8ab8dd37976c3ae7d503e21dd0f5af\n" +
                    "23bb104d10e46eb6fa053cd1af73efa4\n" +
                    "b68f529bfbc634a531659e86744d065b\n" +
                    "0c547c8dc9265f92df57be82c4364bcd\n" +
                    "7fb02a14ea626f3d4a278bb29f028d87\n" +
                    "306a63fb3ff38137c683e02f50e982c6\n" +
                    "0a04e75ef67c3663c8ef18bc8bd0b13e\n" +
                    "-----END OpenVPN Static key V1-----\n" +
                    "</tls-crypt>\n"
        )
    )

    private val random = Random(Date().time)

    fun getSelectedServer(context: Context): ServerModel{
        return serverList[context.getSharedPreferences("TABLE", Context.MODE_PRIVATE).getInt("SELECTED_SERVER", 0)]
    }

    fun setSelectedServer(context: Context, server: ServerModel){
        context.getSharedPreferences("TABLE", Context.MODE_PRIVATE).edit().putInt("SELECTED_SERVER", server.id).apply()
    }

    fun getLast(context: Context): ServerModel{
        return serverList[context.getSharedPreferences("TABLE", Context.MODE_PRIVATE).getInt("LAST_SERVER", 0)]
    }

    fun setLast(context: Context, server: ServerModel){
        context.getSharedPreferences("TABLE", Context.MODE_PRIVATE).edit().putInt("LAST_SERVER", server.id).apply()
    }

    fun generateSpeed(): Int{
        return when (random.nextInt(3)) {
            0 -> {
                R.drawable.s_low
            }
            1 -> {
                R.drawable.s_medium
            }
            else -> {
                R.drawable.s_max
            }
        }
    }


}