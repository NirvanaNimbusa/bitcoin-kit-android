package bitcoin.wallet.kit.network

import bitcoin.wallet.kit.blocks.validators.BlockValidator
import bitcoin.wallet.kit.models.Block
import bitcoin.wallet.kit.models.Header
import bitcoin.walllet.kit.utils.HashUtils

class TestNetBitcoinCash : NetworkParameters() {

    override var port: Int = 18333

    override var magic: Long = 0xf4f3e5f4
    override var bip32HeaderPub: Int = 0x043587cf
    override var bip32HeaderPriv: Int = 0x04358394
    override var addressVersion: Int = 111
    override var addressSegwitHrp: String = "bchtest"
    override var addressScriptVersion: Int = 196
    override var coinType: Int = 1

    override var dnsSeeds: Array<String> = arrayOf(
            "testnet-seed.bitcoinabc.org"
    )

    override val checkpointBlock = Block(Header().apply {
        version = 536870912
        prevHash = HashUtils.toBytesAsLE("00000000000002724a16527c4b048a811ee7821c54bf8daf9e7eb8c07df7f982")
        merkleHash = HashUtils.toBytesAsLE("027db423d24edcd6238234e0ddfe988ee6847abb3e64173b928799071ae32676")
        timestamp = 1537393033
        bits = 436481402
        nonce = 408109711
    }, 1257984)

    override val blockValidator = BlockValidator(this)

    override fun validateBlock(block: Block, previousBlock: Block) {
        blockValidator.validate(block, previousBlock)
    }
}