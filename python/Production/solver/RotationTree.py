class RotationTree:
    
        List<RotationSequence> self.c_array = List<RotationSequence>()
        def __init__(self):
        

        def addRotationLinkedList(self,p_list):
            #Console.Write("FFFFF")
            self.c_array.Add(p_list.getCopy())
        

        def getSize(self):
            return self.c_array.Count
        

        def getRotationSequence(self, p_index):
            return self.c_array[p_index]
        

        @staticmethod
        def getRotationTreeFromFile(RubikFileReader p_File):
           myTree = RotationTree()
           l_rotationLinkedList = RotationSequence()
            while l_rotationLinkedList.readFromFile(p_File))
            
                myTree.addRotationLinkedList(l_rotationLinkedList)
            
            return myTree

        
    

