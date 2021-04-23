class Graph{

    constructor(){
        this.neighbors = {};
        this.nodes = {};
    }

    addNode(node){
        let nodeKey = node.value;
        if (!(nodeKey in this.nodes)){
            this.nodes[nodeKey] = node;
        } 
    }

    addNeighbors(node1, node2){
        let nodeKey = node1.value;
        if (this.neighbors[nodeKey] == undefined){
            this.neighbors[nodeKey] = [];
        }
        this.neighbors[nodeKey].push(node2);

        if (!(node1.value in this.nodes)){
            this.nodes[nodeKey] = node1;
        }

        if (!(node2.value in this.nodes)){
            this.nodes[node2.value] = node2;
        }
    }

    getNeighbors(nodeKey){
        //console.log(this.neighbors[node.getValue]);
        return this.neighbors[nodeKey];
    }

}