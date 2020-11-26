import {
    SETID,
    SETAD
} from './mutation-types'

export default {
    getIdAc ({ commit }, idAc) {
        console.log("action : " +idAc)
        console.log("object type : " + typeof(idAc))
        console.log("object type : " + String(idAc))
        commit(SETID, idAc)
    },
    getAdAc ({ commit }, adAc) {
        console.log("getAdAc : " + adAc)
        commit(SETAD, adAc)
    }
}
