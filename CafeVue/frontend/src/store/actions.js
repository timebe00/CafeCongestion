import {
    SETID,
    SETID2
} from './mutation-types'

export default {
    getIdAc ({ commit }, id) {
        console.log(id)
        commit(SETID, id)
    },
    getIdAc2 ({ commit }, id) {
        console.log("getIdAc2")
        console.log(id.hdid)
        commit(SETID2, id.hdid)
    }
}
