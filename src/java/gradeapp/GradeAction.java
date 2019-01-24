/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 *
 * @author i-am-prinx
 */
public class GradeAction extends Action {
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        GradeBean gb = (GradeBean) form;
        String name = gb.getName();
        String math_sbj = gb.getMath();
        String english_sbj = gb.getEnglish();
        String science_sbj = gb.getScience();
        String language_sbj = gb.getLanguage();
        
        if (math_sbj.matches("\\d++") && english_sbj.matches("\\d++") && 
            science_sbj.matches("\\d++") && language_sbj.matches("\\d++"))
        {
            int math = Integer.parseInt(math_sbj);
            int english = Integer.parseInt(english_sbj);
            int science = Integer.parseInt(science_sbj);
            int language = Integer.parseInt(language_sbj);
            
            /**
             * check that user input isn't negative and not greater than 100
             */
            if ( 
                (math > 100 || english > 100 || science > 100 || language > 100) ||
                (math < 0 || english < 0 || science < 0 || language < 0 )
               )
            {
                return mapping.findForward("error");
            }
            /**   * End check *  **/
            
            
            // Marks              Points                  Grades
            // 75 - 100             5                       A
            // 65 - 74              4                       B
            // 55 - 64              3                       C
            // 45 - 54              2                       D
            // 40 - 44              1                       E
            //  0 - 39              0                       F
            
            char math_gc, english_gc, science_gc, language_gc;
            int math_gp, english_gp, science_gp, language_gp;
            int math_unit = 5, english_unit=4, science_unit = 4, language_unit = 4;
            int total_unit = math_unit + english_unit + science_unit + language_unit;
            
            /**
            * Compute grade character for subject scores 
            */
            math_gc = subjectRateAlphabet(math);
            english_gc = subjectRateAlphabet(english);
            science_gc = subjectRateAlphabet(science);
            language_gc = subjectRateAlphabet(language);
            
            /**
             * Compute grade point for subject grade character
             * Every subject have their unit score, based on the grade ( A, B, C, D)
             * a subject will be assigned a mark that will be multiplied by the subject 
             * unit point.
             */
            math_gp = subjectGradePoint( math_gc, math_unit );
            english_gp = subjectGradePoint( english_gc, english_unit );
            science_gp = subjectGradePoint( science_gc, science_unit );
            language_gp = subjectGradePoint( language_gc, language_unit );
            
            
            
            int total_points = math_gp + english_gp + science_gp + language_gp;
            double grade = (double )total_points / total_unit;
            grade = (double) Math.round(grade * 100.0) / 100.0;
            
                        
            
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("math", math);
            session.setAttribute("math_gc", math_gc);
            session.setAttribute("english", english);
            session.setAttribute("science", science);
            session.setAttribute("language", language);
            session.setAttribute("english_gc", english_gc);
            session.setAttribute("science_gc", science_gc);
            session.setAttribute("language_gc", language_gc);
            session.setAttribute("total_points", total_points);
            session.setAttribute("grade", grade);
            
            
            
            return mapping.findForward("report");
        } 
        else {
            return mapping.findForward("error");
        }
    }
    
    private char subjectRateAlphabet(int subject){
        char alphabet= ' ';
        if (subject >= 75 && subject <= 100 ){ alphabet = 'A';}
            else if (subject >= 65 && subject <= 74 ){ alphabet = 'B';}
            else if (subject >= 55 && subject <= 64 ){ alphabet = 'C';}
            else if (subject >= 45 && subject <= 54 ){ alphabet = 'D';}
            else if (subject >= 40 && subject <= 44 ){ alphabet = 'E';}
            else if (subject >= 0 && subject <= 39 ){ alphabet = 'F';}
        return alphabet;
    }
    
    
    private int subjectGradePoint(char subjectGradeChar, int courseUnit) {
        int point = 0;
        if (subjectGradeChar == 'A') { point = 5 * courseUnit; }
        else if (subjectGradeChar == 'B') { point = 4 * courseUnit; }
        else if (subjectGradeChar == 'C') { point = 3 * courseUnit; }
        else if (subjectGradeChar == 'D') { point = 2 * courseUnit; }
        else if (subjectGradeChar == 'E') { point = 1 * courseUnit; }
        else if (subjectGradeChar == 'F') { point = 0 * courseUnit; }
        return point;
    }
}