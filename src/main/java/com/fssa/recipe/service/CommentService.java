package com.fssa.recipe.service;



import java.text.DecimalFormat;
import java.util.List;

import com.fssa.recipe.dao.CommentDAO;
import com.fssa.recipe.dao.exception.DAOException;
import com.fssa.recipe.model.Comment;
import com.fssa.recipe.service.exception.ServiceException;
import com.fssa.recipe.validation.CommentValidator;
import com.fssa.recipe.validation.exception.InvalidCommentException;

public class CommentService {

	
	
	
    public boolean createComment(Comment comment) throws ServiceException {
        try {
        	CommentValidator.validateComment(comment);
        	CommentDAO commentDAO = new CommentDAO();
            return commentDAO.createComment(comment);
 
        }  catch ( DAOException | InvalidCommentException e) {
        	
            throw new ServiceException("Failed to create comment.");
            
        }
    }
    
    
    
    
    
  

    public List<Comment> getCommentsForRecipeIdDesc(int recipeId) throws ServiceException {
        try {
            CommentDAO commentDAO = new CommentDAO();
            return commentDAO.getCommentsForRecipeIdDesc(recipeId);
        } catch (DAOException e) {
           
            throw new ServiceException(e);
        }
    }
   
    
    public double getAverageRatingForRecipe(int recipeId) throws ServiceException {
        try {
            CommentDAO commentDAO = new CommentDAO();
            double averageRating = commentDAO.getAverageRatingForRecipe(recipeId);

            DecimalFormat df = new DecimalFormat("#.##");
            String formattedRating = df.format(averageRating);

            return Double.parseDouble(formattedRating); 
        } catch (DAOException e) {
           
            throw new ServiceException("Failed to calculate");
        }
    }





	
    
    
    
}