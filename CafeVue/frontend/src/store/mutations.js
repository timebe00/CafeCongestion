import {
    SETID,
    SETAD
} from './mutation-types'

export default {
    [SETID] (state, idAc) {
        console.log("SETID : " + idAc)
        state.idSt = idAc
    },
    [SETAD] (state, adAc) {
        console.log("SETAD : " + adAc)
        state.adSt = adAc
    }
}
