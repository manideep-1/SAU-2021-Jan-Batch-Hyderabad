import React, { Component } from 'react'

export default class Tabledata extends Component {
    constructor(props){

        super(props);
    }
    deleterec(){
        
    }
    render() {
        return (
            // <div class="col">
            //     <tr>
            //         <td>{this.props.id}</td>
            //         <td>{this.props.url}</td>
            //         <td>{this.props.node_id}</td>
            //         <td>{this.props.repos_url}</td>
            //         </tr>
            // </div>
            <tr>
                <div class="row">
                    
                    
                    <div class="col-1">
                    <td>{this.props.id}</td>
                    </div>
                   
                    <div class="col-">
                    
                    <td>{this.props.url}</td>
                    
                    </div><div class="col-4">
                    
                    <td>{this.props.node_id}</td>
                    
                    </div>
                    <div class="col-1">
                    
                    <td>{this.props.repos_url}</td>
                    
                    <div class="col-1">
                        <td>
                    <button onClick={this.deleterec}>delete</button>
                    </td>
                    </div>
                    </div>
                    </div>
                </tr>
        )
    }
}
