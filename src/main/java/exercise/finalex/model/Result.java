package exercise.finalex.model;

import exercise.finalex.Effect;

public class Result<T> {

    private final boolean isSuccess;
    private final T success;
    private final Throwable failure;

    private Result(T success, Throwable failure, boolean isSuccess) {
        this.success = success;
        this.failure = failure;
        this.isSuccess = isSuccess;
    }

    public static <T> Result<T> fromEffect(String description, Effect<T> effect) {
        try {
            return success(effect.get());
        } catch (Exception e) {
            return failure(new RuntimeException("Error :: " + description + ": " + e.getMessage(), e));
        }
    }

    public static <T> Result<T> success(T success) {
        return new Result<T>(success, null, true);
    }

    public static <T> Result<T> failure(Throwable failure) {
        return new Result<T>(null, failure, false);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFailure() {
        return !isSuccess;
    }

    public T get() {
        if (isSuccess())
            return success;
        else
            throw new RuntimeException(failure);
    }

    public Throwable getFailure() {
        return failure;
    }

}

