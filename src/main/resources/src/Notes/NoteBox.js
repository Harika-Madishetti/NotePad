import React from 'react'
import {EditIcon} from "./EditIcon";

class NoteBox extends React.Component{
    render (){
        const {notes} = this.props
        const hasNotes = (notes.title || notes.content)
        return(
            <div className="note">
                <div>
                   <EditIcon/>
                </div>
                {
                    hasNotes ? (
                        <div>
                            {
                                notes.title && <h1>{notes.title}</h1>
                            }
                            {
                                notes.content && <pre>{notes.content}</pre>
                            }
                        </div>
                    ):(
                        <div className="empty">
                            Empty Note
                        </div>
                    )
                }
            </div>
        )
    }
}
export default NoteBox




