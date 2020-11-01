README

# Info
AUTHOR: Connor Kuljis
DATE: 2020/11/01
UNIT: Data Structres and Algorithms (COMP1002) - Curtin University Bently
ABOUT: README file for DSA Assignment 1

# Introduction
# How to run/install the program
## Compilation
* `javac -cp .:json.jar *.java`

## Run the program

* example $ `java -cp .:json.jar -i asset_info.csv exchangeInfo.json`

The program excpects 3 command line arguments

`java -cp .:json.jar cryptoGraph <flag> <asset_file.csv> <trade_data.json>`

where:
    <flag> = '-i' or '-r' for interactive and report mode respectively"
    <asset_file.csv> = asset file
    <trade_data.json> = trade file


# Files
* cryptoGraph.java      - This file provides the main function to run the program.
                        - Is responsible for calling functions that read, write, create and update
			- the graph.
* CryptoCurrency.java   - Class file for creating currency objects.
* CryptoTrade.java      - Class file for creating trade/pair objects.
* DSAGraph.java         - Graph Abstract Data Type (ADT) class.
                          Comprised from DSAGraphVertex and DSAGraphEdge class.
* DSAGraphEdge.java     - Class file for edge objects. Owned by DSAGraph.
* DSAGraphVertex.java   - Class file to store vertex information in graph.
* DSAHeap.java          - Heap Abstract Data Type (ADT) class.
* DSAHeapEntry.java     - Class file for heap entry while is owned by DSAHeap.java
* DSAJson.java          - JSON parser to read finance data.
* DSALinkedList.java    - LinkedList Abstract Data Type (ADT) class.
* DSAListNode.java      - ListNode Abstract Data Type (ADT) class. 
* DSAQueue.java         - Queue Abstract Data Type (ADT) class.
* DSAStack.java         - Stack Abstract Data Type (ADT) class.
* FileIO.java           - File I/O csv parser.
