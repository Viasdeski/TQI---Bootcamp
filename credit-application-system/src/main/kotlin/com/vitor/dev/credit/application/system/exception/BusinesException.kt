package com.vitor.dev.credit.application.system.exception

data class BusinesException(
    override val message: String
    ) : RuntimeException(message) {

}
