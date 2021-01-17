import React from 'react';
import Tabledata from './Tabledata';

class Table extends React.Component{
    constructor(props) {
        super(props);
        this.state={
        data:[
            // {
            //     Firstname:'Manideep',
            //     Lastname:'Laxmishetty',
            //     age:'20'
            // },
            // {
            //     Firstname:'Anudeep',
            //     Lastname:'kakkireni',
            //     age:'22'
            // },
            // {
            //     Firstname:'Phani',
            //     Lastname:'kumar',
            //     age:'20'
            // },
            // {
            //     Firstname:'abhigna',
            //     Lastname:'kakkireni',
            //     age:'25'
            // }
        ],
        // id:"yes",
        // url:'yes',
        // node_id:'yes',
        // repos_url:'yes'
    }
    
    }
    componentDidMount(){
        fetch("https://api.github.com/users/hadley/orgs")
        .then((res) => res.json())
        .then((res) => {
          this.setState({ data: res });
        });
    }
    // changeid=(e)=>{
    //     this.setState({
    //         id:'no'
    //     });
    // }
    // changeurl=(e)=>{
    //     this.setState({
    //         url:'no'
    //     });
    // }
    // changerepos_url=(e)=>{
    //     this.setState({
    //         repos_url:'no'
    //     });
    // }
    // changenode_id=(e)=>{
    //     this.setState({
    //         node_id:'no'
    //     });
    // }
    deleterec=(j,item)=>{
        console.log(item,j)
        console.log(this.state.data[j])
        this.state.data.splice(j,1);
        this.setState({
            data:this.state.data
        })
        
    }
    render(){
    return (
        <div>
            <h2>Table data</h2>
            <div class="container">
            <table >
                
                <tr>
                <div class="row">
                    <div class="col-1">
                    <th >id</th>
                    
                    </div>
                    <div class="col-4">
                    <th >url</th>
                    
                    </div><div class="col-3">
                    <th >node_id</th>
                    
                    </div><div class="col-3">
                    <th >repos_url</th>
                    
                    </div>
                    <div class="col-1">
                        <th>delete</th>
                    </div>
                    </div>
                </tr>
                
                {
                    
                    this.state.data.map((item,i)=>{
                        return (
                            // <Tabledata 
                            // id={item.id} 
                            // url={item.url} 
                            // node_id={item.node_id} 
                            // repos_url={item.repos_url}
                            // // idcheck={this.state.id}
                            // // urlcheck={this.state.url}
                            // // node_idcheck={this.state.node_id}
                            // // repos_urlcheck={this.state.repos_url}
                            // >

                            // </Tabledata>
                            <tr>
                <div class="row">
                    
                    
                    <div class="col-1">
                    <td>{item.id}</td>
                    </div>
                   
                    <div class="col-3">
                    
                    <td>{item.url}</td>
                    
                    </div><div class="col-4">
                    
                    <td>{item.node_id}</td>
                    
                    </div>
                    <div class="col-3">
                    
                    <td>{item.repos_url}</td>
                    
                    <div class="col-1">
                        <td>
                    <button onClick={()=>this.deleterec(i,item)}>delete</button>
                    </td>
                    </div>
                    </div>
                    </div>
                </tr>
                        );
                    })
                }
                
                </table>
                </div>
        </div>
    )
    }
}
export default Table;