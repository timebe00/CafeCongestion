import {
    SETID,
    SETID2
} from './mutation-types'

export default {
    [SETID] (state, id) {
        console.log("SETID : " + id)
        state.id = id
    },
    [SETID2] (state, id) {
        console.log("SETID : " + id)
        state.id = id
    }
}
