class SolutionManager
    

        List<List<SolutionNode>> self.c_solutionList = List<List<SolutionNode>>()


        def __init__(self):
            i
            for i =0 i < 41 i++)
                self.c_solutionList.Add(List<SolutionNode>())
        

        def addSolution(self,p_rotationLinkedList,p_permutation,p_prevSolution,
                         p_value, p_floor):

            if /*(p_value>=32 and getBestValue()>=36) or*/ self.c_solutionList[p_value].Count < 40)
            
                self.c_solutionList[p_value].Add(SolutionNode(Solution(p_rotationLinkedList.getCopy(), p_permutation.getCopy(), p_prevSolution)))

                #         Console.Write("AddedValue=%d, Index=%d\n", p_value, p_value)
            



        


        def getBestUndeveloped(self):
            i = 40
           l_bestSolution = null
            while i >= 0 and l_bestSolution == null)
            
                if self.c_solutionList[i].Count > 0):
                    j = 0
                    while j < self.c_solutionList[i].Count and l_bestSolution == null)
                    
                        SolutionNode l_node = self.c_solutionList[i][j++]
                        if !l_node.isDeveloped())
                        
                            l_bestSolution = l_node.getSolution()
                            l_node.setDeveloped()
                        
                    
                
                i--
            
            return l_bestSolution
        

        def getBest(self):
            i = 40
           l_returnValue = null
            while i >= 0 and l_returnValue == null)
            
                if self.c_solutionList[i].Count > 0)
                    l_returnValue = self.c_solutionList[i][0].getSolution()
                i--
            
            return l_returnValue
        

        def getBestValue(self):
            i = 40
            l_returnValue = 0
            while i >= 0 and l_returnValue == 0)
            
                if self.c_solutionList[i].Count > 0)
                    l_returnValue = i
                i--
            
            return l_returnValue
        

        class SolutionNode
        
           c_solution
            Boolean c_isDeveloped

            def SolutionNode(self,p_solution)
            
                c_isDeveloped = False
                c_solution = p_solution
            

            def getSolution(self)
            
                return c_solution
            


            def isDeveloped(self)
            
                return c_isDeveloped
            

            def setDeveloped(self)
            
                c_isDeveloped = True
            


        
    
