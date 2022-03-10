
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.stream.IntStream;

public class CPCS405Exercise {

	public static void main(String[] args) {

		var name = "Jamsdhi";
		System.out.println(name);
		
		
//
//        String fileName = "sample.txt";
//        
//        PathMatcher mather = FileSystems.getDefault().getPathMatcher("glob:" + fileName);
//        Path root = Paths.get(fileName);
//        
//        if(Files.isDirectory(root)){
//             Path name = root.getFileName();
//             if(name != null && mather.matches(name)){
//                 try{
//                     Files.delete(root);
//                     System.out.println("Delete : " + root);
//                     System.exit(0);
//                 }catch(IOException ex){
//                     System.err.println("Exception deleting file");
//                     System.err.println("Exception : " + ex);
//                     System.exit(-1);
//                 }
//             }
//        }
//        
//        DeleteFileTree deleter = new DeleteFileTree(root, mather);
//        try{
//            Files.walkFileTree(root, deleter);
//        }
//        catch(IOException ex){
//            System.out.println("Exception : " + ex);
//        }
	}
}

class DeleteFileTree implements FileVisitor<Path> {

	private Path file;
	private PathMatcher matcher;
	private int numMatcher;

	public DeleteFileTree(Path file, PathMatcher matcher) {
		this.file = file;
		this.matcher = matcher;
	}

	public void delete(Path file) {
		Path name = file.getFileName();
		if (matcher.matches(name)) {
			try {
				Files.delete(file);
			} catch (IOException ex) {
				System.out.println("Unable to delete : " + ex.getMessage());
				System.out.println("Exception : " + ex);
			}
		}
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		delete(file);
		return CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return CONTINUE;
	}

}