using cube





    class RotationTree
    
        List<RotationSequence> c_array = new List<RotationSequence>()
        def RotationTree():
        

        def addRotationLinkedList(RotationSequence p_list):
            //Console.Write("FFFFF")
            c_array.Add(p_list.getCopy())
        

        def getSize():
            return c_array.Count
        

        def getRotationSequence(p_index):
            return c_array[p_index]
        

        @staticmethod
        def getRotationTreeFromFile(RubikFileReader p_File):
            RotationTree myTree = new RotationTree()
            RotationSequence l_rotationLinkedList = new RotationSequence()
            while l_rotationLinkedList.readFromFile(p_File))
            
                myTree.addRotationLinkedList(l_rotationLinkedList)
            
            return myTree

        
    
