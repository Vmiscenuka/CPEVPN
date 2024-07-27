package secure.cpe.vpn

data class ServerModel(
    var id: Int,
    var name: String,
    var ip: String,
    var flag: Int,
    var ovpn: String
)
